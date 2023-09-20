package com.example.coffeegame.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.coffeegame.R
import com.example.coffeegame.model.Barista
import com.example.coffeegame.model.Sustenance
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Random


object Datasource {

    //data handling functions
    private fun getSustenanceData(): ArrayList<Sustenance>{
        return sustenanceList
        //I don't formally use this one much but it's still probably useful to have idk
    }
    fun getLimitedSustenanceData(): ArrayList<Sustenance> {
        //beware anybody lookin' at this it took a very long time to figure out this part
        //makes a copy of the lists of foods so we can mess with it
        var sustenanceCopy: ArrayList<Sustenance> = getSustenanceData().map { it.copy() } as ArrayList<Sustenance>
        //creates a random seed
        val seed = Random()
        //does a fisher-yates shuffle to the list of foods, using the random seed, which I think is for mutable lists
        // so I cast it to an arraylist
        //TODO: figure out how to sublist this part
        sustenanceCopy= sustenanceCopy.shuffled(seed) as ArrayList<Sustenance>
        return sustenanceCopy as ArrayList<Sustenance>
    }
    private fun getBaristaData(): ArrayList<Barista>{
        return baristaList
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentBarista(): Barista{
        val localTime: LocalTime = getLocalTime()
        //It gets mad with midnight so I just did the ol' canvas trick, 23:59
        return when {
            //shift that ends at 6:00am (starts at 24:00/12:00pm/00:00 //Just the start of the day)
            // practically the night shift
            localTime.isBefore(LocalTime.parse("06:00")) || localTime == LocalTime.parse("06:00") -> {
                getBaristaData()[3]
                //lidoo
            }
            //shift that ends at 12:00am/12:00 (starts at 6:00am)
            localTime.isBefore(LocalTime.parse("12:00")) || localTime == LocalTime.parse("12:00") -> {
                getBaristaData()[0]
                //pyotr
            }
            //shift that ends at 6:00 pm/18:00 (starts at 12:00am/12:00)
            localTime.isBefore(LocalTime.parse("18:00")) || localTime == LocalTime.parse("18:00") -> {
                getBaristaData()[1]
                //rumble
            }
            //shift that ends at midnight/24:00/00:00/end of day (starts at 6:00pm/18:00)
            localTime.isBefore(LocalTime.parse("23:59")) || localTime == LocalTime.parse("23:59") -> {
                getBaristaData()[2]
                //nara
            }
            //hanging else in case anything goes wrong
            else -> getBaristaData().random()
            //picks random barista
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)     //jesus this took several days, the documentation around this area is not great
    fun getLocalTime(): LocalTime {         //I <3 Java
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
            R.drawable.food_footwich,
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
            R.drawable.food_fidget_burger,
            R.string.burger_name,
            R.string.burger_price,
            R.string.burger_description,
            R.string.burger_death_statement
        ),
        Sustenance(
            4,
            R.drawable.food_spider_donut,
            R.string.spider_donut_name,
            R.string.spider_donut_price,
            R.string.spider_donut_description,
            R.string.spider_donut_death_statement
        ),
        Sustenance(
            5,
            R.drawable.food_coffee_cream,
            R.string.cold_brew_name,
            R.string.cold_brew_price,
            R.string.cold_brew_description,
            R.string.cold_brew_death_statement
        ),
        Sustenance(
            6,
            R.drawable.food_frosty,
            R.string.milkshake_name,
            R.string.milkshake_price,
            R.string.milkshake_description,
            R.string.milkshake_death_statement
        ),
        Sustenance(
            7,
            R.drawable.food_iced_drink,
            R.string.iced_tea_name,
            R.string.iced_tea_price,
            R.string.iced_tea_description,
            R.string.iced_tea_death_statement
        ),
        Sustenance(
            8,
            R.drawable.food_pink_lemonade,
            R.string.pink_lemonade_name,
            R.string.pink_lemonade_price,
            R.string.pink_lemonade_description,
            R.string.pink_lemonade_death_statement
        ),
        Sustenance(
            9,
            R.drawable.food_pitcher,
            R.string.pitcher_name,
            R.string.pitcher_price,
            R.string.pitcher_description,
            R.string.pitcher_death_statement
        ),
        Sustenance(
            10,
            R.drawable.food_punk_lemonade,
            R.string.punk_lemonade_name,
            R.string.punk_lemonade_price,
            R.string.punk_lemonade_description,
            R.string.punk_lemonade_death_statement,
        ),
        Sustenance(
            11,
            R.drawable.food_blackberry_pie,
            R.string.blackberry_pie_name,
            R.string.blackberry_pie_price,
            R.string.blackberry_pie_description,
            R.string.blackberry_pie_death_statement
        ),
        Sustenance(
            12,
            R.drawable.food_dodo_bird,
            R.string.dodo_bird_name,
            R.string.dodo_bird_price,
            R.string.dodo_bird_description,
            R.string.dodo_bird_death_statement
        ),
        Sustenance(
            13,
            R.drawable.food_house_salad,
            R.string.house_salad_name,
            R.string.house_salad_price,
            R.string.house_salad_description,
            R.string.house_salad_death_statement
        ),
        Sustenance(
            14,
            R.drawable.goth_tea,
            R.string.hot_goth_tea_name,
            R.string.hot_goth_tea_price,
            R.string.hot_goth_tea_description,
            R.string.hot_goth_tea_death_statement
        ),
        Sustenance(
            15,
            R.drawable.food_tea_ice,
            R.string.tea_ice_name,
            R.string.tea_ice_price,
            R.string.tea_ice_description,
            R.string.tea_ice_death_statement
        ),
        Sustenance(
            16,
            R.drawable.food_zebra_ice_cream_sandwich,
            R.string.zebra_ice_cream_sandwich_name,
            R.string.zebra_ice_cream_sandwich_price,
            R.string.zebra_ice_cream_sandwich_description,
            R.string.zebra_ice_cream_sandwich_death_statement
        )
    )
    private val baristaList: ArrayList<Barista> = arrayListOf(
        Barista(
            0,
            R.string.pyotr_name,
            R.drawable.character_pyotr_storefront_morning,
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
                R.drawable.character_rumble_storefront_day,
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
            ),
        Barista(
            2,
            R.string.nara_name,
            R.drawable.character_nara_storefront_evening,
            R.string.nara_custom_chat_name,
            R.string.nara_default_greeting,
            //nara advice list
            arrayListOf(
                R.string.nara_advice_1,
                R.string.nara_advice_2
            ),
            //nara chat list
            arrayListOf(
                R.string.nara_chat_1,
                R.string.nara_chat_2
            ),
            //nara flirt response list
            arrayListOf(
                R.string.nara_flirt_1,
                R.string.nara_flirt_2
            ),
            //nara custom advice list... affirmations!
            arrayListOf(
                R.string.nara_custom_1,
                R.string.nara_custom_2,
                R.string.nara_custom_3,
                R.string.nara_custom_4,
                R.string.nara_custom_5,
                R.string.nara_custom_6,
                R.string.nara_custom_7,
            )
        ),
        Barista(
            3,
            R.string.lidoo_name,
            R.drawable.character_lidoo_storefront_night,
            R.string.lidoo_custom_chat_name,
            R.string.lidoo_greeting,
            //lidoo advice list
            arrayListOf(
                R.string.lidoo_advice_1,
                R.string.lidoo_advice_2
            ),
            //lidoo chat list
            arrayListOf(
                R.string.lidoo_chat_1,
                R.string.lidoo_chat_2
            ),
            //lidoo flirt response list
            arrayListOf(
                R.string.lidoo_flirt_1,
                R.string.lidoo_flirt_2
            ),
            //lidoo custom list.. opinions on menu items
            arrayListOf(
                R.string.lidoo_custom_chat_1,
                R.string.lidoo_custom_chat_2
            ),
        )
    )
}