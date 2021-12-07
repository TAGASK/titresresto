package com.example.titresresto.listanddetails.feature.data.remote

import com.google.gson.annotations.SerializedName

data class TransactionsDto(
    @SerializedName("transactions") var transactions : List<TransactionDto>,
)
