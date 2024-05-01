package com.hs.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private int size;
	private PlayingPiece[][] board;

	public Board(int size) {
		this.size = size;
		board = new PlayingPiece[size][size];
	}

	public boolean addPiece(int row, int column, PlayingPiece playingPiece) {

		if (board[row][column] != null) {
			return false;
		}
		board[row][column] = playingPiece;
		return true;
	}

	public List<Pair> getFreeCells() {
		List<Pair> freeCells = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == null) {
					Pair rowColumn = new Pair(i, j);
					freeCells.add(rowColumn);
				}
			}
		}
		return freeCells;
	}

	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] != null) {
					System.out.print(board[i][j].getPieceType().name() + "   ");
				} else {
					System.out.print("    ");

				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public PlayingPiece[][] getBoard() {
		return board;
	}

	public void setBoard(PlayingPiece[][] board) {
		this.board = board;
	}
}
