package com.hs;

public enum PieceType {
	PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING;

	public Piece create() {
		return new Piece(this);
	}
}
