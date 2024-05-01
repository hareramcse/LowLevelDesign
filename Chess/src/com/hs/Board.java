package com.hs;

import com.hs.impl.PieceFactory;

public class Board {
	private static Board instance = new Board();
	private Square[][] squares;

	private Board() {
		squares = new Square[8][8];
		initializeBoard();
	}

	private void initializeBoard() {
		PieceFactory factory = new PieceFactory();
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				squares[row][col] = new Square(row, col);
			}
		}
		// Add Pawns for both players
		for (int col = 0; col < 8; col++) {
			squares[1][col].placePiece(factory.createPiece("Pawn"));
			squares[6][col].placePiece(factory.createPiece("Pawn"));
		}
		// Add Rooks for both players
		squares[0][0].placePiece(factory.createPiece("Rook"));
		squares[0][7].placePiece(factory.createPiece("Rook"));
		squares[7][0].placePiece(factory.createPiece("Rook"));
		squares[7][7].placePiece(factory.createPiece("Rook"));
		// Add Knights for both players
		squares[0][1].placePiece(factory.createPiece("Knight"));
		squares[0][6].placePiece(factory.createPiece("Knight"));
		squares[7][1].placePiece(factory.createPiece("Knight"));
		squares[7][6].placePiece(factory.createPiece("Knight"));
		// Add Bishops for both players
		squares[0][2].placePiece(factory.createPiece("Bishop"));
		squares[0][5].placePiece(factory.createPiece("Bishop"));
		squares[7][2].placePiece(factory.createPiece("Bishop"));
		squares[7][5].placePiece(factory.createPiece("Bishop"));
		// Add Queens
		squares[0][3].placePiece(factory.createPiece("Queen"));
		squares[7][3].placePiece(factory.createPiece("Queen"));
		// Add Kings
		squares[0][4].placePiece(factory.createPiece("King"));
		squares[7][4].placePiece(factory.createPiece("King"));
	}

	public static Board getInstance() {
		return instance;
	}

	public Square getSquare(int row, int col) {
		return squares[row][col];
	}
}