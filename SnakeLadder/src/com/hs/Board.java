package com.hs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> jumps = new HashMap<>();

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        snakes.forEach(s -> jumps.put(s.head(), s.tail()));
        ladders.forEach(l -> jumps.put(l.bottom(), l.top()));
    }

    public int size() { return size; }

    public int resolve(int position) {
        return jumps.getOrDefault(position, position);
    }
}
