package com.hs.impl;

import java.util.List;

import com.hs.CellPosition;
import com.hs.service.Piece;

public class Knight extends Piece {

	public boolean move(CellPosition fromPosition, CellPosition toPosition) {
		return false;
	}

	public List<CellPosition> possibleMoves(CellPosition fromPosition) {
		return null;
	}

	public boolean validate(CellPosition fromPosition, CellPosition toPosition) {
		return false;
	}

}