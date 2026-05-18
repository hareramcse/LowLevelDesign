package com.hs.impl;

public class Queen implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Queen to " + newRow + "," + newCol);
	}
}