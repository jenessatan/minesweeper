package com.company;



public class Board {

    private Level.Difficulty level;
    private int gridSize;
    private int numMines;
    private Cell[][] board;

    public Board(Level.Difficulty level) {
        this.level = level;
        this.gridSize = level.getDimensions();
        this.numMines = level.getNumBombs();
        this.board = new Cell[this.gridSize][this.gridSize];
    }

    public void init() {
        for(int row = 0; row < gridSize; row++) {
            for(int col = 0; col < gridSize; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    public void playGame() {
        boolean isGameOver = false;
        boolean isDead = false;
        printBoard();
    }

    private void printBoard() {
        printBoardHeader();
        for(int row = 0; row < gridSize; row++) {
            if(row > 9) {
                System.out.print(row+" ");
            } else {
                System.out.print(row+"  ");
            }
            for(int col = 0; col < gridSize; col++) {
                Cell cell = board[row][col];
                cell.printCell();
                if(col == gridSize - 1){
                    System.out.print("\n");
                }
            }
        }
    }

    private void printBoardHeader() {
        for(int i = 0; i < gridSize; i++) {
            if(i == 0) {
                System.out.print("    "+i);
            } else if (i > 9){
                System.out.print(" "+i);
            }else {
                System.out.print("  "+i);
            }
        }
        System.out.print("\n");
    }
}
