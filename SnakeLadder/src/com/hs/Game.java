package com.hs;

import java.util.List;
import java.util.Random;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Random dice = new Random();

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void play() {
        while (true) {
            for (Player player : players) {
                int roll = dice.nextInt(6) + 1;
                int next = Math.min(player.position() + roll, board.size());
                int resolved = board.resolve(next);

                System.out.printf("%s rolled %d, moved %d -> %d", player.name(), roll, next, resolved);
                if (resolved != next) {
                    System.out.print(resolved > next ? " (ladder!)" : " (snake!)");
                }
                System.out.println();

                player.setPosition(resolved);
                if (resolved == board.size()) {
                    System.out.println(player.name() + " wins!");
                    return;
                }
            }
        }
    }
}
