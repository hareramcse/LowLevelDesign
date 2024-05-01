package com.hs.impl;

import com.hs.service.Piece;

public class PieceFactory {
	public Piece createPiece(String type) {
		switch (type) {
		case "Pawn":
			return new Pawn();
		case "Rook":
			return new Rook();
		case "Knight":
			return new Knight();
		case "Bishop":
			return new Bishop();
		case "Queen":
			return new Queen();
		case "King":
			return new King();
		default:
			throw new IllegalArgumentException("Invalid piece type: " + type);
		}
	}
}
