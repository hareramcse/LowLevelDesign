package com.hs.impl;

public class Bishop implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Bishop to " + newRow + "," + newCol);
	}
}