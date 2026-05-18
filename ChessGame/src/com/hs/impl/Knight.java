package com.hs.impl;

public class Knight implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Knight to " + newRow + "," + newCol);
	}
}