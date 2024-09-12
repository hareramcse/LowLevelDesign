package com.hs;

import java.util.Scanner;

public class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Scanner scanner;

	public Game() {
		board = new Board();
		player1 = new Player("Player X", 'X');
		player2 = new Player("Player O", 'O');
		currentPlayer = player1;
		scanner = new Scanner(System.in);
	}

	// Play the game
	public void play() {
		boolean isGameOngoing = true;
		while (isGameOngoing) {
			board.printBoard();
			playerMove();
			isGameOngoing = !isGameOver();
			if (isGameOngoing) {
				switchPlayer();
			}
		}
		board.printBoard();
		announceResult();
	}

	// Handle the player's move
	private void playerMove() {
		int row, col;
		while (true) {
			System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0, 1, or 2):");
			row = scanner.nextInt();
			col = scanner.nextInt();

			if (board.isValidMove(row, col)) {
				board.setCell(row, col, currentPlayer.getSymbol());
				break;
			} else {
				System.out.println("This move is invalid. Try again.");
			}
		}
	}

	// Check if the game is over (win or draw)
	private boolean isGameOver() {
		return checkWinner() || board.isFull();
	}

	// Switch the current player
	private void switchPlayer() {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
	}

	// Check if there's a winner
	private boolean checkWinner() {
		char symbol = currentPlayer.getSymbol();

		// Check rows and columns
		for (int i = 0; i < 3; i++) {
			if ((board.getCell(i, 0) == symbol && board.getCell(i, 1) == symbol && board.getCell(i, 2) == symbol)
					|| (board.getCell(0, i) == symbol && board.getCell(1, i) == symbol
							&& board.getCell(2, i) == symbol)) {
				return true;
			}
		}

		// Check diagonals
		if ((board.getCell(0, 0) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 2) == symbol)
				|| (board.getCell(0, 2) == symbol && board.getCell(1, 1) == symbol && board.getCell(2, 0) == symbol)) {
			return true;
		}

		return false;
	}

	// Announce the result of the game
	private void announceResult() {
		if (checkWinner()) {
			System.out.println(currentPlayer.getName() + " wins!");
		} else {
			System.out.println("The game is a draw!");
		}
	}
}