package com.hs.impl;

public class Pawn implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Pawn to " + newRow + "," + newCol);
	}
}