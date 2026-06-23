package com.hs;

public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char getCell(int row, int col) { return grid[row][col]; }

    public void setCell(int row, int col, char mark) { grid[row][col] = mark; }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == '-';
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '-') return false;
            }
        }
        return true;
    }
}
