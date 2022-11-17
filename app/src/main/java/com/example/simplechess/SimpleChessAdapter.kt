package com.example.simplechess

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import kotlin.math.floor
import kotlin.math.min

class SimpleChessAdapter(
    private val context: Context,
    private val pieces: List<ChessPiece>//,
//    private val cardClickListener: CardClickListener
) : RecyclerView.Adapter<SimpleChessAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "SimpleChessAdapter"
        private const val MARGIN_SIZE = 0
    }

    interface CardClickListener {
        fun onCardClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val spaceWidth = parent.width / 8
        val spaceHeight = parent.height / 8
        val spaceSideLength = min(spaceWidth, spaceHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.generic_board_piece, parent, false)
        Log.i(TAG, "Made the view")
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = spaceSideLength
        layoutParams.height = spaceSideLength
        layoutParams.setMargins(MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun getItemCount() = 64

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(holder.adapterPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val boardPiece = itemView.findViewById<ImageButton>(R.id.genericBoardPiece)

        fun bind(position: Int) {
//            Log.i(TAG, "Position is $position")
            ////////// so bad
            val boardPositions: BooleanArray = booleanArrayOf(true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true)
            var shouldBeWhite = boardPositions[position]
            val black = "#4A4A4A"
            val white = "#ECE3E3"
            boardPiece.setBackgroundColor(if (shouldBeWhite) Color.parseColor(black) else Color.parseColor(white))
            boardPiece.setOnClickListener {
                Log.i(TAG, "Clicked on position $position")
                try {
                    val p = pieces.first { it.position == position }
                    val x = p.drawable
                    boardPiece.setImageResource(p.drawable)
                    boardPiece.imageAlpha = if(p.color == "white") Color.parseColor("#FFFFFF") else Color.parseColor("#000000")
                } catch (e: Exception) {
                    boardPiece.setImageResource(R.drawable.ic_no_position)
                }
            }
            // get the piece
//            try {
//                val p = pieces.first { it.position == position }
////                Log.i(TAG, "p is $p")
//                boardPiece.setImageResource(p.drawable)
//            } catch (e: Exception) {
//                Log.i("IGNORE", "$e")
//            }
        }
    }
}