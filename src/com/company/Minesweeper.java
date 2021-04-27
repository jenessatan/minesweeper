package com.company;

import java.util.Scanner;

public class Minesweeper {

    private static Board board;

    public static void main(String[] args) {
        initializeGame();
        board.playGame();
    }

    public static void initializeGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the minesweeper!");
        boolean isSettingUp = true;
        Level.Difficulty lvl = Level.Difficulty.E;
        do {
            System.out.println("\nSet your difficulty level (e/m/h): ");
            String input = scanner.nextLine().toUpperCase();
            if (!input.equals("E") && !input.equals("M") && !input.equals("H")) {
                System.out.println("Invalid difficulty level");
            } else {
                lvl = Level.Difficulty.valueOf(input);
                System.out.println("You've chosen: " + lvl.getDifficulty());
                System.out.println("This level contains " + lvl.getNumBombs() + " bombs in a " + lvl.getDimensions() + " by " + lvl.getDimensions() + " grid\n");
                System.out.println("Do you want to continue (y/n): ");
                input = scanner.nextLine().toUpperCase();
                if(input.equals("Y")) {
                    isSettingUp = false;
                }
            }
        } while (isSettingUp);
        board = new Board(lvl);
        board.init();
        System.out.println("\nLet's play!");
    }
}
