package com.company;

public class Cell {
    private boolean isBomb;
    private boolean isRevealed;
    private int value;
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.isBomb = false;
        this.isRevealed = false;
        this.value = 0;
    }

    public void setBomb() {
        this.isBomb = true;
    }

    public boolean getIsBomb() {
        return this.isBomb;
    }

    public void setRevealed() {
        this.isRevealed = true;
    }

    public void reveal() {
        // todo
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getRow(){return this.row;}

    public int getColumn() {return this.column;}

    public void printCell() {
        if (!isRevealed) {
            System.out.print("[ ]");
        } else if (isBomb) {
            System.out.print("[*]");
        } else if(value == 0) {
            System.out.print("[-]");
        } else {
            System.out.print("[" + value + "]");
        }
    }
}
