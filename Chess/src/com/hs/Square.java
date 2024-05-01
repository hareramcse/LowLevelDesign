package com.hs;

import com.hs.service.Piece;

public class Square {
	private Piece piece;
	private int row;
	private int col;

	public Square(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void placePiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
