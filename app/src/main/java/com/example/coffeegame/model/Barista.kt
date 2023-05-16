package com.example.coffeegame.model

import androidx.annotation.DrawableRes

data class Barista(
    val id: Int,
    val name: String,
    @DrawableRes val imageResourceId: Int,
    //name of custom chat in chat fragment
    val customChatName: String,
    val normalGreetingStatement: String,

    //used in chat fragment
    val adviceList: ArrayList<String>,
    val chatList: ArrayList<String>,
    val flirtList: ArrayList<String>,
    val customList: ArrayList<String>,
    )