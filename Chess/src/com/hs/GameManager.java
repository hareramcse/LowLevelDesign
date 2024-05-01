package com.hs;

import com.hs.service.Move;

public class GameManager {
	private Board board;
	private Player currentPlayer;
	private Player opponent;

	GameManager(Player player1, Player player2) {
		board = Board.getInstance();
		currentPlayer = player1;
		opponent = player2;
	}

	void playMove(Move move) {
		move.execute();
		// Switch players
		Player temp = currentPlayer;
		currentPlayer = opponent;
		opponent = temp;
	}

	void printBoard() {
		// Print the current board state
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
}
