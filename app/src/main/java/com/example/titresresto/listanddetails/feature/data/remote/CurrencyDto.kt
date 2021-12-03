package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.Currency
import com.google.gson.annotations.SerializedName

data class CurrencyDto(

    @SerializedName("iso_3"  ) var iso3   : String,
    @SerializedName("symbol" ) var symbol : String,
    @SerializedName("title"  ) var title  : String

) {
    fun toCurrency(): Currency {
        return Currency(
            iso3 = iso3,
            symbol = symbol,
            title = title
        )
    }
}
