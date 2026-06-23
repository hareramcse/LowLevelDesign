package com.hs;

public class Move {
	private final Piece piece;
	private final Square fromSquare;
	private final Square toSquare;

	public Move(Piece piece, Square fromSquare, Square toSquare) {
		this.piece = piece;
		this.fromSquare = fromSquare;
		this.toSquare = toSquare;
	}

	public void execute() {
		piece.move(toSquare.getRow(), toSquare.getCol());
		fromSquare.placePiece(null);
		toSquare.placePiece(piece);
	}
}
