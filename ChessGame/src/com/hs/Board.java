package com.hs;

public class Board {
	private static final Board instance = new Board();
	private final Square[][] squares = new Square[8][8];

	private Board() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				squares[row][col] = new Square(row, col);
			}
		}
		setupPieces();
	}

	private void setupPieces() {
		for (int col = 0; col < 8; col++) {
			squares[1][col].placePiece(PieceType.PAWN.create());
			squares[6][col].placePiece(PieceType.PAWN.create());
		}
		place(PieceType.ROOK, 0, 0);
		place(PieceType.ROOK, 0, 7);
		place(PieceType.ROOK, 7, 0);
		place(PieceType.ROOK, 7, 7);
		place(PieceType.KNIGHT, 0, 1);
		place(PieceType.KNIGHT, 0, 6);
		place(PieceType.KNIGHT, 7, 1);
		place(PieceType.KNIGHT, 7, 6);
		place(PieceType.BISHOP, 0, 2);
		place(PieceType.BISHOP, 0, 5);
		place(PieceType.BISHOP, 7, 2);
		place(PieceType.BISHOP, 7, 5);
		place(PieceType.QUEEN, 0, 3);
		place(PieceType.QUEEN, 7, 3);
		place(PieceType.KING, 0, 4);
		place(PieceType.KING, 7, 4);
	}

	private void place(PieceType type, int row, int col) {
		squares[row][col].placePiece(type.create());
	}

	public static Board getInstance() {
		return instance;
	}

	public Square getSquare(int row, int col) {
		return squares[row][col];
	}
}
