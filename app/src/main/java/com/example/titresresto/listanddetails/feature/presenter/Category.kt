package com.example.titresresto.listanddetails.feature.presenter

import androidx.compose.ui.graphics.Color
import com.example.titresresto.R

class Category {
    companion object {
        fun selectIcon(categorySI: String?): CategoryObject {
            val color = 0xCCFFEBD4
            val color2 = 0xCCFB9C3A
            when (categorySI) {
                CategoryConstants.BURGER ->
                    return CategoryObject(R.drawable.ic_vector_burger,
                        "Big Fernand"
                        , Color(color),
                        Color(color2))
                CategoryConstants.BAKERY ->
                    return CategoryObject(R.drawable.ic_vector_birthday_cake,
                        "Boulangerie"
                        , Color(color),
                        Color(color2))
                CategoryConstants.COMPUTER ->
                        return CategoryObject(R.drawable.ic_vector_computer,
                            "FNAC"
                            , Color(0xCCFDE0F0),
                            Color(0xCCFA75BC))
                CategoryConstants.DONATION ->
                        return CategoryObject(R.drawable.ic_vector_cashback,
                            "Unicef"
                            , Color(color),
                            Color(color2))
                CategoryConstants.SUSHI ->
                        return CategoryObject(R.drawable.ic_vector_sushi,
                            "Sushi WA"
                            , Color(color),
                            Color(color2))
                CategoryConstants.SUPERMARKET ->
                        return CategoryObject(R.drawable.ic_vector_supermarket,
                            "Monoprix"
                            , Color(color),
                            Color(color2))
                CategoryConstants.MEAL_VOUCHER ->
                        return CategoryObject(R.drawable.ic_vector_fork_knife,
                            "Brasserie"
                            , Color(color),
                            Color(color2))

                CategoryConstants.GIFT ->
                        return CategoryObject(R.drawable.ic_vector_gift,
                            "Gift"
                            , Color(0xCCFDE0F0),
                            Color(0xCCFA75BC))
                CategoryConstants.MOBILITY ->
                        return CategoryObject(R.drawable.ic_vector_car,
                            "Transport"
                            , Color(color),
                            Color(color2))

            }
            return CategoryObject(R.drawable.ic_vector_burger,
                "Big Fernand"
                , Color(color),
                Color(color2))
        }
    }

}