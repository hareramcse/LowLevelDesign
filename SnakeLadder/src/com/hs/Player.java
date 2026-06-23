package com.hs;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 1;
    }

    public String name() { return name; }
    public int position() { return position; }
    public void setPosition(int position) { this.position = position; }
}
