package com.example.coffeegame.model

import androidx.annotation.DrawableRes

data class Sustenance(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    val name: Int,
    val price: Int,
    val description: Int,
    val deathStatement: Int
    )