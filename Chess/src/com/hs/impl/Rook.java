package com.hs.impl;

import com.hs.service.Piece;

public class Rook implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Rook to " + newRow + "," + newCol);
	}
}