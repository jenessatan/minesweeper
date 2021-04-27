package com.company;

public class Cell {
    private boolean isBomb;
    private boolean isRevealed;
    private int value;
    private int row;
    private int column;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.isBomb = false;
        this.isRevealed = false;
        this.value = -1;
    }

    public void setBomb() {
        this.isBomb = true;
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

    public void printCell() {
        if(!isRevealed){
            System.out.print("[ ]");
        } else if(isBomb){
            System.out.print("[*]");
        } else {
            System.out.println("["+value+"]");
        }
    }
}
