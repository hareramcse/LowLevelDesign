package com.hs.impl;

import com.hs.service.Piece;

public class Queen implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Queen to " + newRow + "," + newCol);
	}
}