package com.hs;

public class GameManager {
	private final Board board;
	private Player currentPlayer;
	private Player opponent;

	GameManager(Player player1, Player player2) {
		board = Board.getInstance();
		currentPlayer = player1;
		opponent = player2;
	}

	void playMove(Move move) {
		move.execute();
		Player temp = currentPlayer;
		currentPlayer = opponent;
		opponent = temp;
	}

	void printBoard() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece piece = board.getSquare(row, col).getPiece();
				System.out.print(piece == null ? ". " : piece.getType().name().charAt(0) + " ");
			}
			System.out.println();
		}
	}
}
