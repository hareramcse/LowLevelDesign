package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final String name;
	private final List<Move> moves = new ArrayList<>();

	public Player(String name) {
		this.name = name;
	}

	public void addMove(Move move) {
		moves.add(move);
	}
}
