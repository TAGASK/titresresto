package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import com.google.gson.annotations.SerializedName

data class TransactionDto(
    @SerializedName("name"       ) var name      : String,
    @SerializedName("type"       ) var type      : String,
    @SerializedName("date"       ) var date      : String,
    @SerializedName("message"    ) var message   : String,
    @SerializedName("amount"     ) var amount    : AmountDto,
    @SerializedName("small_icon" ) var smallIcon : SmallIconDto,
    @SerializedName("large_icon" ) var largeIcon : LargeIconDto
) {
    fun toTransaction() : Transaction {
        return Transaction(
            name = name,
            type = type,
            date = date,
            message = message,
            amount = amount.toAmount(),
            smallIcon = smallIcon.toIcon(),
            largeIcon = largeIcon.toIcon()
        )
    }
}
