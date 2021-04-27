package com.company;


import java.util.Random;
import java.util.Scanner;

public class Board {

    private Level.Difficulty level;
    private int gridSize;
    private int numMines;
    private Cell[][] board;
    private int revealedCount;

    public Board(Level.Difficulty level) {
        this.level = level;
        this.gridSize = level.getDimensions();
        this.numMines = level.getNumBombs();
        this.board = new Cell[this.gridSize][this.gridSize];
        this.revealedCount = 0;
    }

    public void init() {
        int totalCells = gridSize * gridSize;
        int[][] bombs = new int[totalCells][2];
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                board[row][col] = new Cell(row, col);
                int bombIdx = row * gridSize + col;
                bombs[bombIdx] = new int[]{row, col};
            }
        }
        placeMines(bombs);
        populateCellValues();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;
        boolean isDead = false;
        int selectedRow;
        int selectedColumn;
        do {
            System.out.println("Current board status: ");
            printBoard();
            System.out.println("Select a row: ");
            selectedRow = scanner.nextInt();
            System.out.println("Select a column: ");
            selectedColumn = scanner.nextInt();
            if(board[selectedRow][selectedColumn].getIsBomb()) {
                isGameOver = true;
                isDead = true;
                revealAll();
            } else {
                revealCell(selectedRow, selectedColumn);
                if(revealedCount >= ((gridSize * gridSize) - numMines)) {
                    isGameOver = true;
                }
            }
        } while(!isGameOver);
        System.out.println("GAME OVER!");
        printBoard();
        if(isDead) {
            System.out.println("Sorry! The cell you chose blew up and now you're dead!");
        } else {
            System.out.println("Congratulations! You won!");
        }
    }

    private void printBoard() {
        printBoardHeader();
        for (int row = 0; row < gridSize; row++) {
            if (row > 9) {
                System.out.print(row + " ");
            } else {
                System.out.print(row + "  ");
            }
            for (int col = 0; col < gridSize; col++) {
                Cell cell = board[row][col];
                cell.printCell();
                if (col == gridSize - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    private void printBoardHeader() {
        for (int i = 0; i < gridSize; i++) {
            if (i == 0) {
                System.out.print("    " + i);
            } else if (i > 9) {
                System.out.print(" " + i);
            } else {
                System.out.print("  " + i);
            }
        }
        System.out.print("\n");
    }

    private void placeMines(int[][] bombs) {
        Random random = new Random();
        int randomIndex;
        int row;
        int col;
        int placedMines = 0;
        while (placedMines < numMines) {
            randomIndex = random.nextInt(bombs.length - 1);
            int[] randomCell = bombs[randomIndex];
            row = randomCell[0];
            col = randomCell[1];
            if (!board[row][col].getIsBomb()) {
                board[row][col].setBomb();
                placedMines++;
            }
        }
    }

    private void revealAll() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                board[row][col].setRevealed();
            }
        }
    }

    private void populateCellValues() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                Cell cell = board[row][col];
                if (!cell.getIsBomb()) {
                    int cellValue = countSurroundingBombs(row, col);
                    cell.setValue(cellValue);
                }
            }
        }
    }

    private int countSurroundingBombs(int row, int col) {
        int bombCount = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            // check to see if out of row bounds
            if (r < 0 || r >= gridSize) {
                continue;
            }
            for (int c = col - 1; c <= col + 1; c++) {
                // check to see if out of column bounds
                if (c < 0 || c >= gridSize || (r == row && c == col)) {
                    continue;
                }
                if (board[r][c].getIsBomb()) {
                    bombCount++;
                }
            }
        }
        return bombCount;
    }

    private void revealCell(int row, int col) {
        Cell cell = board[row][col];
        if(!cell.getRevealed()) {
            revealedCount++;
            cell.setRevealed();
        } else {
          return;
        }
        if(cell.getValue() > 0) {
            return;
        }
        for (int r = row - 1; r <= row + 1; r++) {
            // check to see if out of row bounds
            if (r < 0 || r >= gridSize) {
                continue;
            }
            for (int c = col - 1; c <= col + 1; c++) {
                // check to see if out of column bounds
                if (c < 0 || c >= gridSize || (r == row && c == col)) {
                    continue;
                }
                if (!board[r][c].getIsBomb()) {
                    revealCell(r, c);
                }
            }
        }
    }
}
