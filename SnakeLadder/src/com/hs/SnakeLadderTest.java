package com.hs;

import java.util.List;

public class SnakeLadderTest {
    public static void main(String[] args) {
        Board board = new Board(100,
                List.of(new Snake(17, 7), new Snake(54, 34), new Snake(62, 19), new Snake(98, 79)),
                List.of(new Ladder(3, 22), new Ladder(5, 8), new Ladder(28, 84), new Ladder(72, 91)));

        Game game = new Game(board, List.of(new Player("Alice"), new Player("Bob")));
        game.play();
    }
}
