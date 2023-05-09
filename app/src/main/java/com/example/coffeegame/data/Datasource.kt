package com.example.coffeegame.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coffeegame.R
import com.example.coffeegame.model.Barista
import com.example.coffeegame.model.Sustenance
import java.util.Calendar
import java.util.TimeZone

object Datasource {

    //data handling functions
    fun getSustenanceData(): ArrayList<Sustenance>{
        return sustenanceList
    }
    fun getBaristaData(): ArrayList<Barista>{
        return baristaList
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun getLocalTime(): Long
    {
        val currentDate = Calendar.getInstance()
        return currentDate.timeInMillis + TimeZone.getDefault().getOffset(currentDate.timeInMillis)
    }

    //declared lists here

    private val sustenanceList: ArrayList<Sustenance> = arrayListOf(
        Sustenance(
            1,
            R.drawable.food_hotdog,
            "HotDogDog",
            "1.0005 dollaroos",
            "The dog sees your sin.. how could you eat her",
            "Death is inevitable.. you have simply hastened my end."
        ),
        Sustenance(
            2,
            R.drawable.food_hotdog,
            "Overpriced Panini",
            "30√2 fake dollar",
        "A sandwich that costs a hopefully nonliteral arm and a leg",
            "Death is merely a change in form! End, I welcome thee."
        ),
        Sustenance(
            3,
            R.drawable.food_to_go_coffee,
            "normal coffee",
            ".3 cents",
        "No additions, a classic choice.",
            "I'm going to 4D, baby!"
        ),
        Sustenance(
            4,
            R.drawable.food_hotdog,
            "Hot or Not Tea",
            "3.35$",
            "A lovely option for a dull morning or a scenic night",
            "I hope I taste alright. It's not like I know, I can't taste myself."
        ),
        Sustenance(
            5,
            R.drawable.food_fidget_burger,
            "Burger",
            "7 million",
            "Yeah it's edible no problem",
            "I hope you get indigestion."
        ),
        Sustenance(
            6,
            R.drawable.food_spider_donut,
            "Spider Donut",
            "2.00$",
            "Lovely spider donut",
            "You and I are one taste from absolution."
        ),
        Sustenance(
            7,
            R.drawable.food_coffee_cream,
            "Cream Cold Brew",
            "3.00$",
            "Cold brew with creme",
            "Ok now we switch I eat you now."
        ),
        Sustenance(
            8,
            R.drawable.food_frosty,
            "Malkshake",
            "300$",
            "It fell off the back of a truck ..you can have it if you want",
            "You've wasted my soul on a meal."
        ),
        Sustenance(
            9,
            R.drawable.food_iced_drink,
            "Iced Tea",
            "2$",
            "We put the tea... on ice",
            "I am happy to fall to such a foe as yourself. "
        ),
        Sustenance(
            10,
            R.drawable.food_pink_lemonade,
            "Pink Lemonade",
            ".667 dogglers",
            "Pink lemonade to share with your bestest friends :)",
            "Eat me and we shall be one."
        ),
        Sustenance(
            11,
            R.drawable.food_pitcher,
            "Entire Pitcher of Cold Brew Coffee",
            "10 doler",
            "Did you mean to order a whole pitcher?",
            "Please tell me you're at least sharing me and not chugging an entire pitcher."
        )
    )
    private val baristaList: ArrayList<Barista> = arrayListOf(
            Barista(
                1,
                "Rumble",
                R.drawable.character_rumble_storefront,
                "Tiger Facts",
                //rumble advice list
                arrayListOf(
                    "When the going gets tough, play dead!",
                    "Don't forget that your health is priority #1. It's harder to do things if you don't take care of yourself",
                    "It's not a waste of time if you enjoyed wasting it"
                ),
                //rumble chat list
                arrayListOf(
                    "The weather around here is so peculiar, how is it where you are?",
                    "The weirdest thing happened earlier.. I went outside and the floor suddenly stopped existing."
                ),
                //rumble flirt response list
                arrayListOf(
                    "I'm sorry I don't think I understand what you mean by that",
                    "Thank you! I find my stripes quite fetching as well"
                ),
                //rumble custom advice list.. tiger facts!
                arrayListOf(
                    "Tigers are the most beautiful cats (^･ｪ･^)",
                    "The strength of the tiger is really impressive (^=˃ᆺ˂)",
                    "Fossil remains of tigers found in parts of China are believed to be 2 million years old! (,,^・⋏・^,,)",
                    "(^=˃ᆺ˂) No two tigers have the same stripes!",
                    "Tigers are the largest of all the Asian big cats ≽ܫ≼"
                )
            )
    )
}