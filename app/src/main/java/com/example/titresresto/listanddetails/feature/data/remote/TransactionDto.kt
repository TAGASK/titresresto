package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import com.google.gson.annotations.SerializedName
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class TransactionDto(
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("type"       ) var type      : String? = null,
    @SerializedName("date"       ) var date      : String? = null,
    @SerializedName("message"    ) var message   : String? = null,
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
