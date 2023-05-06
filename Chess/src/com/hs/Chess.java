package com.hs;

import java.util.List;

import com.hs.service.Piece;

public class Chess {
	ChessBoard chessBoard;
	Player[] player;
	Player currentPlayer;
	List<Move> movesList;
	GameStatus gameStatus;

	public boolean playerMove(CellPosition fromPosition, CellPosition toPosition, Piece piece) {
		return false;
	}

	public boolean endGame() {
		return false;
	}

	private void changeTurn() {
		
	}

}