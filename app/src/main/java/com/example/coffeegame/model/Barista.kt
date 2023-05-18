package com.example.coffeegame.model

import androidx.annotation.DrawableRes

data class Barista(
    val id: Int,
    val name: Int,
    @DrawableRes val imageResourceId: Int,
    //name of custom chat in chat fragment
    val customChatName: Int,
    val normalGreetingStatement: Int,

    //used in chat fragment
    val adviceList: ArrayList<Int>,
    val chatList: ArrayList<Int>,
    val flirtList: ArrayList<Int>,
    val customList: ArrayList<Int>,
    )