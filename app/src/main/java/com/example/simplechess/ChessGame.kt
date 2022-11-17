package com.example.simplechess

import android.util.Log

class ChessGame(pieceNames: List<String>) {

    companion object {
        private const val TAG = "ChessGame"
    }

    val pieces: List<ChessPiece>
    val board: MutableList<BoardPiece>

    init {
        val randomisedPieces = pieceNames.shuffled()
        pieces = randomisedPieces.mapIndexed { idx, it ->
            val positionOnBoard = (0..63).random()
            ChessPiece(idx, it, "white", R.drawable.ic_temp_icon)
        }
        Log.i(TAG, "Pieces: $pieces")
        board = mutableListOf<BoardPiece>()
        repeat(64) {
            board.add(BoardPiece(it.hashCode(), "$it"))
        }
    }
}