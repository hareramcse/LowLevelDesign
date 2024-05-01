package com.hs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.hs.Model.Board;
import com.hs.Model.Pair;
import com.hs.Model.PieceType;
import com.hs.Model.Player;
import com.hs.Model.PlayingPiece;
import com.hs.Model.PlayingPieceO;
import com.hs.Model.PlayingPieceX;

public class TicTacToeGame {
	private Deque<Player> players;
	private Board gameBoard;

	public void initializeGame() {

		// creating 2 Players
		players = new LinkedList<>();
		PlayingPieceX crossPiece = new PlayingPieceX();
		Player player1 = new Player("Player1", crossPiece);

		PlayingPieceO noughtsPiece = new PlayingPieceO();
		Player player2 = new Player("Player2", noughtsPiece);

		players.add(player1);
		players.add(player2);

		// initializeBoard
		gameBoard = new Board(3);
	}

	public String startGame() {
		boolean noWinner = true;
		try (Scanner scanner = new Scanner(System.in)) {
			while (noWinner) {

				// take out the player whose turn is and also put the player in the list back
				Player playerTurn = players.removeFirst();

				// get the free space from the board
				gameBoard.printBoard();
				List<Pair> freeSpaces = gameBoard.getFreeCells();
				if (freeSpaces.isEmpty()) {
					noWinner = false;
					continue;
				}

				// read the user input
				System.out.print("Player:" + playerTurn.getName() + " Enter row,column: ");
				String s = scanner.nextLine();
				String[] values = s.split(",");
				int inputRow = Integer.valueOf(values[0]);
				int inputColumn = Integer.valueOf(values[1]);

				// place the piece
				boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn,
						playerTurn.getPlayingPiece());
				if (!pieceAddedSuccessfully) {
					// player can not insert the piece into this cell, player has to choose another
					// cell
					System.out.println("Incorrect possition chosen, try again");
					players.addFirst(playerTurn);
					continue;
				}
				players.addLast(playerTurn);

				boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().getPieceType());
				if (winner) {
					return playerTurn.getName();
				}
			}
			return "tie";
		}
	}

	public boolean isThereWinner(int row, int column, PieceType pieceType) {
		boolean rowMatch = true;
		boolean columnMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonalMatch = true;

		// need to check in row
		int size = gameBoard.getSize();
		for (int i = 0; i < size; i++) {
			PlayingPiece[][] board = gameBoard.getBoard();
			if (board[row][i] == null || board[row][i].getPieceType() != pieceType) {
				rowMatch = false;
			}
		}

		// need to check in column
		for (int i = 0; i < size; i++) {
			PlayingPiece[][] board = gameBoard.getBoard();
			if (board[i][column] == null || board[i][column].getPieceType() != pieceType) {
				columnMatch = false;
			}
		}

		// need to check diagonals
		for (int i = 0, j = 0; i < size; i++, j++) {
			PlayingPiece[][] board = gameBoard.getBoard();
			if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
				diagonalMatch = false;
			}
		}

		// need to check anti-diagonals
		for (int i = 0, j = size - 1; i < size; i++, j--) {
			PlayingPiece[][] board = gameBoard.getBoard();
			if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
				antiDiagonalMatch = false;
			}
		}

		return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
	}

}
