package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.Amount
import com.google.gson.annotations.SerializedName

data class AmountDto(

    @SerializedName("value"    ) var value    : Double,
    @SerializedName("currency" ) var currency : CurrencyDto

) {
    fun toAmount(): Amount {
        return Amount(
            value = value,
            currency = currency.toCurrency()
        )
    }
}
