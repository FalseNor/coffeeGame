package com.example.coffeegame.data

import com.example.coffeegame.R
import com.example.coffeegame.model.Sustenance

object Datasource {
    val sustenanceList: List<Sustenance> = listOf(
        Sustenance(
            R.drawable.food_hotdog,
            "HotDogDog",
            "1.0005 dollaroonies",
            "The dog sees your sin"
        ),
        Sustenance(
            R.drawable.food_hotdog,
            "Overpriced Panini",
            "300√2 digeridollars",
        "A sandwich that costs a hopefully nonliteral arm and a leg"
        ),
        Sustenance(
            R.drawable.food_hotdog,
            "normal coffee",
            ".3 cents",
        "No additions allowed. You're drinking it black because I don't want to make a bunch of sprites"
        ),
        Sustenance(
            R.drawable.tea_time,
            "Hot or Not Tea",
            "3.35$",
            "A lovely option for a dull morning or a scenic night"
        )
    )
}