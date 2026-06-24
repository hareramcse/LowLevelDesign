package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private final String id;
	private final String name;
	private final List<MenuItem> menu = new ArrayList<>();

	public Restaurant(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public void addMenuItem(MenuItem item) {
		menu.add(item);
	}

	public List<MenuItem> menu() {
		return menu;
	}
}
