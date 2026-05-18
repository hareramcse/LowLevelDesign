package com.hs;

import com.hs.impl.Piece;
import com.hs.service.Move;
import com.hs.service.MoveCommand;

public class ChessGameTest {
	public static void main(String[] args) {
        Board board = Board.getInstance();
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        GameManager gameManager = new GameManager(player1, player2);

        // Example: Create a move for player 1 (Pawn to 2,0)
        Piece pawn = board.getSquare(1, 0).getPiece();
        Square toSquare = board.getSquare(2, 0);
        Move move1 = new MoveCommand(pawn, board.getSquare(1, 0), toSquare);
        player1.addMove(move1);

        // Play the move
        gameManager.playMove(move1);

        // Print the board after the move
        gameManager.printBoard();
    }
}
