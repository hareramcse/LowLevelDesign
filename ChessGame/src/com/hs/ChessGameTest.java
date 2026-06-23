package com.hs;

public class ChessGameTest {
	public static void main(String[] args) {
		Board board = Board.getInstance();
		Player player1 = new Player("Alice");
		Player player2 = new Player("Bob");
		GameManager gameManager = new GameManager(player1, player2);

		Piece pawn = board.getSquare(1, 0).getPiece();
		Square toSquare = board.getSquare(2, 0);
		Move move1 = new Move(pawn, board.getSquare(1, 0), toSquare);
		player1.addMove(move1);

		gameManager.playMove(move1);
		gameManager.printBoard();
	}
}
