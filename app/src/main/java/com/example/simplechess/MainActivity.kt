package com.example.simplechess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SimpleChess"
    }

    private lateinit var clRoot : CoordinatorLayout
    private lateinit var rvBoard : RecyclerView

    private lateinit var chessGame : ChessGame
    private lateinit var adapter : SimpleChessAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clRoot = findViewById(R.id.clRoot)
        rvBoard = findViewById(R.id.rvBoard)

        setupBoard()
    }

    private fun setupBoard() {
//        val pieces = listOf("Queen", "Pawn", "Knight", "King", "Bishop")
        val pieces = listOf("Pawn", "Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn", "Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn", "Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn", "Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn","Pawn")
        Log.i(TAG, "pieces: $pieces")
        chessGame = ChessGame(pieces)
        Log.i(TAG, "made chessGame Object")
        adapter = SimpleChessAdapter(this, chessGame.pieces)
        Log.i(TAG, "Made the adapter")
        rvBoard.adapter = adapter
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, 8)
    }
}