package com.hs;

public class Board {
	private char[][] grid;

	public Board() {
		grid = new char[3][3];
		initializeBoard();
	}

	// Initialize the board with empty spaces
	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = '-';
			}
		}
	}

	// Print the current state of the board
	public void printBoard() {
		System.out.println("Current board:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Get the current value at a specific cell
	public char getCell(int row, int col) {
		return grid[row][col];
	}

	// Set a cell with the current player's mark
	public void setCell(int row, int col, char playerMark) {
		grid[row][col] = playerMark;
	}

	// Check if a move is valid
	public boolean isValidMove(int row, int col) {
		return row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == '-';
	}

	// Check if the board is full (for a draw)
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}