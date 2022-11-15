package com.example.simplechess

class ChessGame(pieceNames: List<String>) {

    val pieces: List<ChessPiece>
    val board: MutableList<BoardPiece>

    init {
        val randomisedPieces = pieceNames.shuffled()
        pieces = randomisedPieces.map { ChessPiece(it.hashCode(), it) }
        board = mutableListOf<BoardPiece>()
        repeat(64) {
            board.add(BoardPiece(it.hashCode(), "$it"))
        }
    }
}