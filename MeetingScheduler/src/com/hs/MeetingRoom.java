package com.hs;

public class MeetingRoom {
	private final String id;
	private final String name;
	private final int capacity;

	public MeetingRoom(String id, String name, int capacity) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public int capacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return name + " (cap " + capacity + ")";
	}
}
