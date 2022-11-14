package com.example.simplechess

class ChessGame(pieceNames: List<String>) {

    val pieces: List<ChessPiece>

    init {
        val randomisedPieces = pieceNames.shuffled()
        pieces = randomisedPieces.map { ChessPiece(it.hashCode(), it) }
    }
}