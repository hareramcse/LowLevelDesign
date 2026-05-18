package com.hs.impl;

public class Rook implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Rook to " + newRow + "," + newCol);
	}
}