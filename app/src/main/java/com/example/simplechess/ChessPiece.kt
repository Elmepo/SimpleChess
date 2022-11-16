package com.example.simplechess

data class ChessPiece(
    val position: Int,
    val type: String? = null,
    val color: String? = "white",
    val drawable: Int
)
