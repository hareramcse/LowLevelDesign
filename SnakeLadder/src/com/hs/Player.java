package com.hs;

public class Player {
	private String id;
	private int currentPosition;

	public Player(String id, int currentPosition) {
		this.id = id;
		this.currentPosition = currentPosition;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
}
