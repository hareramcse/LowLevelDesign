package com.hs.impl;

public class King implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving King to " + newRow + "," + newCol);
	}
}