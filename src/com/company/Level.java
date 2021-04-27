package com.company;

// Easy – 9 * 9 Board and 10 Mines
// Medium – 16 * 16 Board and 40 Mines
// Advanced – 24 * 24 Board and 99 Mines

public class Level {
    public enum Difficulty {
        H ("HARD"),
        M ("MEDIUM"),
        E ("EASY")
        ;

        private final String difficulty;

        Difficulty(String code) {
            this.difficulty = code;
        }
        public String getDifficulty() {
            return this.difficulty;
        }

        public int getDimensions() {
            switch(this.difficulty) {
                case "HARD":
                    return 15;
                case "MEDIUM":
                    return 10;
                case "EASY":
                default:
                    return 5;
            }
        }

        public int getNumBombs() {
            switch(this.difficulty) {
                case "HARD":
                    return 20;
                case "MEDIUM":
                    return 15;
                case "EASY":
                default:
                    return 10;
            }
        }
    }

}
