package com.example.coffeegame.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coffeegame.R
import com.example.coffeegame.model.Barista
import com.example.coffeegame.model.Sustenance
import java.time.LocalTime
import java.time.format.DateTimeFormatter


object Datasource {

    //data handling functions
    fun getSustenanceData(): ArrayList<Sustenance>{
        return sustenanceList
    }
    private fun getBaristaData(): ArrayList<Barista>{
        return baristaList
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentBarista(): Barista{
        val localTime: LocalTime = getLocalTime()
        when {
            localTime.isBefore(LocalTime.parse("09:00")) || localTime == LocalTime.parse("09:00") -> {
                return baristaList[0]
            }
            localTime.isAfter(LocalTime.parse("09:00")) -> {
                return baristaList[1]
            }
        }
        return getBaristaData()[0]
    }

    @RequiresApi(Build.VERSION_CODES.O)     //jesus this took several days, the documentation around this area is not great
    fun getLocalTime(): LocalTime {         //I <3 Java :3
        val nowTime= LocalTime.now()        //important to note that localtime  doesn't know anything about the date
        val formatter = DateTimeFormatter.ofPattern("HH:mm")    //foul
        val timeTxt = nowTime.format(formatter)
        return LocalTime.parse(timeTxt, formatter)
    }

    //declared lists here
    private val sustenanceList: ArrayList<Sustenance> = arrayListOf(
        Sustenance(
            0,
            R.drawable.food_hotdog,
            R.string.hotdogdog_name,
            R.string.hotdogdog_price,
            R.string.hotdogdog_description,
            R.string.hotdogdog_death_statement
        ),
        Sustenance(
            1,
            R.drawable.food_hotdog,
            R.string.overpriced_panini_name,
            R.string.overpriced_panini_price,
            R.string.overpriced_panini_description,
            R.string.overpriced_panini_death_statement
        ),
        Sustenance(
            2,
            R.drawable.food_to_go_coffee,
            R.string.normal_coffee_name,
            R.string.normal_coffee_price,
            R.string.normal_coffee_description,
            R.string.normal_coffee_death_statement
        ),
        Sustenance(
            3,
            R.drawable.food_hotdog,
            R.string.tea_name,
            R.string.tea_price,
            R.string.tea_description,
            R.string.tea_death_statement
        ),
        Sustenance(
            4,
            R.drawable.food_fidget_burger,
            R.string.burger_name,
            R.string.burger_price,
            R.string.burger_description,
            R.string.burger_death_statement
        ),
        Sustenance(
            5,
            R.drawable.food_spider_donut,
            R.string.spider_donut_name,
            R.string.spider_donut_price,
            R.string.spider_donut_description,
            R.string.spider_donut_death_statement
        ),
        Sustenance(
            6,
            R.drawable.food_coffee_cream,
            R.string.cold_brew_name,
            R.string.cold_brew_price,
            R.string.cold_brew_description,
            R.string.cold_brew_death_statement
        ),
        Sustenance(
            7,
            R.drawable.food_frosty,
            R.string.milkshake_name,
            R.string.milkshake_price,
            R.string.milkshake_description,
            R.string.milkshake_death_statement
        ),
        Sustenance(
            8,
            R.drawable.food_iced_drink,
            R.string.iced_tea_name,
            R.string.iced_tea_price,
            R.string.iced_tea_description,
            R.string.iced_tea_death_statement
        ),
        Sustenance(
            9,
            R.drawable.food_pink_lemonade,
            R.string.pink_lemonade_name,
            R.string.pink_lemonade_price,
            R.string.pink_lemonade_description,
            R.string.pink_lemonade_death_statement
        ),
        Sustenance(
            10,
            R.drawable.food_pitcher,
            R.string.pitcher_name,
            R.string.pitcher_price,
            R.string.pitcher_description,
            R.string.pitcher_death_statement
        )
    )
    private val baristaList: ArrayList<Barista> = arrayListOf(
        Barista(
            0,
            R.string.pyotr_name,
            R.drawable.character_pyotr_storefront,
            R.string.pyotr_custom_chat_name,
            R.string.pyotr_main_default_greeting,
            //pyotr advice list
            arrayListOf(
                R.string.pyotr_advice_1,
                R.string.pyotr_advice_2
            ),
            //pyotr chat list
            arrayListOf(
                R.string.pyotr_chat_1,
                R.string.pyotr_chat_2
            ),
            //pyotr flirt response list
            arrayListOf(
                R.string.pyotr_flirt_1,
                R.string.pyotr_flirt_2
            ),
            //pyotr custom response list.. list of lies
            arrayListOf(
                R.string.pyotr_custom_1,
                R.string.pyotr_custom_2,
                R.string.pyotr_custom_3
            )
        ),
        Barista(
                1,
                R.string.rumble_name,
                R.drawable.character_rumble_storefront,
                R.string.rumble_custom_chat_name,
                R.string.rumble_main_default_greeting,
                //rumble advice list
                arrayListOf(
                    R.string.rumble_advice_1,
                    R.string.rumble_advice_2,
                    R.string.rumble_advice_3
                ),
                //rumble chat list
                arrayListOf(
                    R.string.rumble_chat_1,
                    R.string.rumble_chat_2
                ),
                //rumble flirt response list
                arrayListOf(
                    R.string.rumble_flirt_1,
                    R.string.rumble_flirt_2
                ),
                //rumble custom advice list.. tiger facts!
                arrayListOf(
                    R.string.rumble_custom_1,
                    R.string.rumble_custom_2,
                    R.string.rumble_custom_3,
                    R.string.rumble_custom_4,
                    R.string.rumble_custom_5
                )
            )
    )
}