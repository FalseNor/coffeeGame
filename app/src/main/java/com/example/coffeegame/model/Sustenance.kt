package com.example.coffeegame.model

import androidx.annotation.DrawableRes

data class Sustenance (
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val price: String,
    val description: String,
    val deathStatement: String
    )