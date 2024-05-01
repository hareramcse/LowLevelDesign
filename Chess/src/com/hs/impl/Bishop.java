package com.hs.impl;

import com.hs.service.Piece;

public class Bishop implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Bishop to " + newRow + "," + newCol);
	}
}