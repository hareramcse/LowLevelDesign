package com.hs.Model;

public class PlayingPiece {
	private PieceType pieceType;

	PlayingPiece(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
}
