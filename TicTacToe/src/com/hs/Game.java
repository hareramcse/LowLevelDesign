package com.hs;

import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private final Player player1 = new Player("Player X", 'X');
    private final Player player2 = new Player("Player O", 'O');
    private Player current = player1;
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        while (true) {
            board.printBoard();
            playerMove();
            if (hasWinner() || board.isFull()) break;
            current = current == player1 ? player2 : player1;
        }
        board.printBoard();
        System.out.println(hasWinner() ? current.name() + " wins!" : "The game is a draw!");
    }

    private void playerMove() {
        while (true) {
            System.out.println(current.name() + "'s turn. Enter row and column (0, 1, or 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.isValidMove(row, col)) {
                board.setCell(row, col, current.symbol());
                return;
            }
            System.out.println("Invalid move. Try again.");
        }
    }

    private boolean hasWinner() {
        char s = current.symbol();
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == s && board.getCell(i, 1) == s && board.getCell(i, 2) == s) return true;
            if (board.getCell(0, i) == s && board.getCell(1, i) == s && board.getCell(2, i) == s) return true;
        }
        return (board.getCell(0, 0) == s && board.getCell(1, 1) == s && board.getCell(2, 2) == s)
                || (board.getCell(0, 2) == s && board.getCell(1, 1) == s && board.getCell(2, 0) == s);
    }
}
