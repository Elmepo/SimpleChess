package com.example.simplechess

import android.content.Context
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
    private val pieces: List<ChessPiece>
) : RecyclerView.Adapter<SimpleChessAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "SimpleChessAdapter"
        private const val MARGIN_SIZE = 0
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

//    override fun getItemCount() = pieces.size
    override fun getItemCount() = 64

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(position)
        holder.bind(holder.adapterPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val whiteBoardPiece = itemView.findViewById<ImageButton>(R.id.genericBoardPiece)

        fun bind(position: Int) {
            Log.i(TAG, "Position is $position")
//            if (position % 2 == 0) {
//                val chessPiece = pieces[position]
//            }
//            if (position > pieces.size - 1) {
//                val chessPiece = pieces[0]
//            } else {
//                val chessPiece = pieces[position]
//            }
//            if (position % 2 == 0) {
//                // board piece should be white
//            } else {
//                // board piece should be black
//            }
            ////////// so bad
            val boardPositions: BooleanArray = booleanArrayOf(true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true, true, false, true, false, true, false, true, false, false, true, false, true, false, true, false, true)
            var shouldBeWhite = boardPositions[position]
            whiteBoardPiece.setImageResource(if (shouldBeWhite) R.drawable.ic_white_board_piece else R.drawable.ic_black_board_piece)
        }
    }
}