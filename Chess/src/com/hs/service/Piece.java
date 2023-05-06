package com.hs.service;

import java.util.List;

import com.hs.CellPosition;
import com.hs.Color;

public abstract class Piece {

	Color color;

	public boolean move(CellPosition fromPosition, CellPosition toPosition) {
		return false;
	}
	public List<CellPosition> possibleMoves(CellPosition fromPosition){
		return null;
	}
	public boolean validate(CellPosition fromPosition, CellPosition toPosition) {
		return false;
	}
}