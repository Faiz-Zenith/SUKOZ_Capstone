package com.muhammadiyah.sukozapp.model

import com.muhammadiyah.sukozapp.R

data class Category(
    val id: String,
    val name: String
)

data class Recipe(
    val id: Int,
    val name: String,
    val category: String,
    val imageUrl: String,
    val imageRes: Int = R.drawable.placeholder_image
)
