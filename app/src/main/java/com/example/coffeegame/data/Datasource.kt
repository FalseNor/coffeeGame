package com.example.coffeegame.data

import com.example.coffeegame.R
import com.example.coffeegame.model.Sustenance

object Datasource {
    fun getSustenanceData(): ArrayList<Sustenance>{
        return sustenanceList
    }

    private val sustenanceList: ArrayList<Sustenance> = arrayListOf(
        Sustenance(
            1,
            R.drawable.food_hotdog,
            "HotDogDog",
            "1.0005 dollaroonies",
            "The dog sees your sin.. how could you eat her"
        ),
        Sustenance(
            2,
            R.drawable.food_hotdog,
            "Overpriced Panini",
            "300√2 digeridollars",
        "A sandwich that costs a hopefully nonliteral arm and a leg"
        ),
        Sustenance(
            3,
            R.drawable.food_to_go_coffee,
            "normal coffee",
            ".3 cents",
        "No additions, a classic choice."
        ),
        Sustenance(
            4,
            R.drawable.food_hotdog,
            "Hot or Not Tea",
            "3.35$",
            "A lovely option for a dull morning or a scenic night"
        ),
        Sustenance(
            5,
            R.drawable.food_fidget_burger,
            "Burger",
            "7 million",
            "Yeah it's edible no problem"
        ),
        Sustenance(
            6,
            R.drawable.food_spider_donut,
            "Spider Donut",
            "2.00$",
            "Lovely spider donut"
        ),
        Sustenance(
            7,
            R.drawable.food_coffee_cream,
            "Cream Cold Brew",
            "3.00$",
            "Cold brew with creme"
        ),
        Sustenance(
            8,
            R.drawable.food_frosty,
            "Frosty",
            "300$",
            "It fell off the back of a truck ..you can have it if you want"
        ),
        Sustenance(
            9,
            R.drawable.food_iced_drink,
            "Iced Tea",
            "2$",
            "We put the tea... on ice"
        ),
        Sustenance(
            10,
            R.drawable.food_pink_lemonade,
            "Pink Lemonade",
            ".667 dogglers",
            "Pink lemonade to share with your bestest friends :)"
        ),
        Sustenance(
            11,
            R.drawable.food_pitcher,
            "Entire Pitcher of Cold Brew Coffee",
            "10 doler",
            "Did you mean to order a whole pitcher?"
        )
    )
}