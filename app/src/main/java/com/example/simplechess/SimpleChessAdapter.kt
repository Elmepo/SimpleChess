package com.example.simplechess

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import kotlin.math.min

class SimpleChessAdapter(
    private val context: Context,
    private val pieces: List<ChessPiece>
) : RecyclerView.Adapter<SimpleChessAdapter.ViewHolder>() {

    companion object {
        private const val TAG = "SimpleChessAdapter"
        private const val MARGIN_SIZE = 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val spaceWidth = parent.width / 8
        val spaceHeight = parent.height / 8
        val spaceSideLength = min(spaceWidth, spaceHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.chess_piece, parent, false)
        Log.i(TAG, "Made the view")
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = spaceSideLength
        layoutParams.height = spaceSideLength
        layoutParams.setMargins(MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE,MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun getItemCount() = pieces.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(position)
        holder.bind(holder.adapterPosition)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

        fun bind(position: Int) {
            Log.i(TAG, "Position is $position")
            val chessPiece = pieces[position]
        }
    }
}