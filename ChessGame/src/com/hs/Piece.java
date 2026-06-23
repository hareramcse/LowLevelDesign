package com.hs;

public class Piece {
	private final PieceType type;

	public Piece(PieceType type) {
		this.type = type;
	}

	public void move(int newRow, int newCol) {
		System.out.println("Moving " + type + " to " + newRow + "," + newCol);
	}

	public PieceType getType() {
		return type;
	}
}
