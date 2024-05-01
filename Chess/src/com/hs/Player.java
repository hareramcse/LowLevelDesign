package com.hs;

import java.util.ArrayList;
import java.util.List;

import com.hs.service.Move;

public class Player {
	private String name;
	private List<Move> moves;

	public Player(String name) {
		this.name = name;
		moves = new ArrayList<>();
	}

	public void addMove(Move move) {
		moves.add(move);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

}
