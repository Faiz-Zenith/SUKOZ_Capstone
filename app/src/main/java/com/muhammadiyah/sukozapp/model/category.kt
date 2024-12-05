package com.muhammadiyah.sukozapp.model

data class Category(
    val id: String,
    val name: String
)

data class Recipe(
    val id: Int,
    val name: String,
    val category: String,
    val imageUrl: String
)
