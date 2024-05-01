package com.hs.service;

import com.hs.Square;

public class MoveCommand implements Move {
	private Piece piece;
	private Square fromSquare;
	private Square toSquare;

	public MoveCommand(Piece piece, Square fromSquare, Square toSquare) {
		this.piece = piece;
		this.fromSquare = fromSquare;
		this.toSquare = toSquare;
	}

	@Override
	public void execute() {
		piece.move(toSquare.getRow(), toSquare.getCol());
        fromSquare.placePiece(null);
        toSquare.placePiece(piece);
	}

	@Override
	public void undo() {
		// Undo move
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Square getFromSquare() {
		return fromSquare;
	}

	public void setFromSquare(Square fromSquare) {
		this.fromSquare = fromSquare;
	}

	public Square getToSquare() {
		return toSquare;
	}

	public void setToSquare(Square toSquare) {
		this.toSquare = toSquare;
	}
}