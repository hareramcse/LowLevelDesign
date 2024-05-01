package com.hs.impl;

import com.hs.service.Piece;

public class Pawn implements Piece {

	@Override
	public void move(int newRow, int newCol) {
		System.out.println("Moving Pawn to " + newRow + "," + newCol);
	}
}