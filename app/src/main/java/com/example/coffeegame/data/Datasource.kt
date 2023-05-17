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
    fun getCurrentBarista(): Barista{
        return baristaList[1]
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
            R.string.hotdogdog_name.toString(),
            R.string.hotdogdog_price.toString(),
            R.string.hotdogdog_description.toString(),
            R.string.hotdogdog_death_statement.toString()
        ),
        Sustenance(
            2,
            R.drawable.food_hotdog,
            R.string.overpriced_panini_name.toString(),
            R.string.overpriced_panini_price.toString(),
            R.string.overpriced_panini_description.toString(),
            R.string.overpriced_panini_death_statement.toString()
        ),
        Sustenance(
            3,
            R.drawable.food_to_go_coffee,
            R.string.normal_coffee_name.toString(),
            R.string.normal_coffee_price.toString(),
            R.string.normal_coffee_description.toString(),
            R.string.normal_coffee_death_statement.toString()
        ),
        Sustenance(
            4,
            R.drawable.food_hotdog,
            R.string.tea_name.toString(),
            R.string.tea_price.toString(),
            R.string.tea_description.toString(),
            R.string.tea_death_statement.toString()
        ),
        Sustenance(
            5,
            R.drawable.food_fidget_burger,
            R.string.burger_name.toString(),
            R.string.burger_price.toString(),
            R.string.burger_description.toString(),
            R.string.burger_death_statement.toString()
        ),
        Sustenance(
            6,
            R.drawable.food_spider_donut,
            R.string.spider_donut_name.toString(),
            R.string.spider_donut_price.toString(),
            R.string.spider_donut_description.toString(),
            R.string.spider_donut_death_statement.toString()
        ),
        Sustenance(
            7,
            R.drawable.food_coffee_cream,
            R.string.cold_brew_name.toString(),
            R.string.cold_brew_price.toString(),
            R.string.cold_brew_description.toString(),
            R.string.cold_brew_death_statement.toString()
        ),
        Sustenance(
            8,
            R.drawable.food_frosty,
            R.string.milkshake_name.toString(),
            R.string.milkshake_price.toString(),
            R.string.milkshake_description.toString(),
            R.string.milkshake_death_statement.toString()
        ),
        Sustenance(
            9,
            R.drawable.food_iced_drink,
            R.string.iced_tea_name.toString(),
            R.string.iced_tea_price.toString(),
            R.string.iced_tea_description.toString(),
            R.string.iced_tea_death_statement.toString()
        ),
        Sustenance(
            10,
            R.drawable.food_pink_lemonade,
            R.string.pink_lemonade_name.toString(),
            R.string.pink_lemonade_price.toString(),
            R.string.pink_lemonade_description.toString(),
            R.string.pink_lemonade_death_statement.toString()
        ),
        Sustenance(
            11,
            R.drawable.food_pitcher,
            R.string.pitcher_name.toString(),
            R.string.pitcher_price.toString(),
            R.string.pitcher_description.toString(),
            R.string.pitcher_death_statement.toString()
        )
    )
    private val baristaList: ArrayList<Barista> = arrayListOf(
        Barista(
            0,
            R.string.pyotr_name.toString(),
            R.drawable.character_pyotr_storefront,
            R.string.pyotr_custom_chat_name.toString(),
            R.string.pyotr_main_default_greeting.toString(),
            //pyotr advice list
            arrayListOf(
                R.string.pyotr_advice_1.toString(),
                ""
            ),
            //pyotr chat list
            arrayListOf(
                R.string.pyotr_chat_1.toString(),
                ""
            ),
            //pyotr flirt response list
            arrayListOf(
                R.string.pyotr_flirt_1.toString(),
                R.string.pyotr_flirt_2.toString()
            ),
            //pyotr custom response list.. list of lies
            arrayListOf(
                R.string.pyotr_custom_1.toString(),
                ""
            )
        ),
        Barista(
                1,
                R.string.rumble_name.toString(),
                R.drawable.character_rumble_storefront,
                R.string.rumble_custom_chat_name.toString(),
                R.string.rumble_main_default_greeting.toString(),
                //rumble advice list
                arrayListOf(
                    R.string.rumble_advice_1.toString(),
                    R.string.rumble_advice_2.toString(),
                    R.string.rumble_advice_3.toString()
                ),
                //rumble chat list
                arrayListOf(
                    R.string.rumble_chat_1.toString(),
                    R.string.rumble_chat_2.toString()
                ),
                //rumble flirt response list
                arrayListOf(
                    R.string.rumble_flirt_1.toString(),
                    R.string.rumble_flirt_2.toString()
                ),
                //rumble custom advice list.. tiger facts!
                arrayListOf(
                    R.string.rumble_custom_1.toString(),
                    R.string.rumble_custom_2.toString(),
                    R.string.rumble_custom_3.toString(),
                    R.string.rumble_custom_4.toString(),
                    R.string.rumble_custom_5.toString()
                )
            )
    )
}