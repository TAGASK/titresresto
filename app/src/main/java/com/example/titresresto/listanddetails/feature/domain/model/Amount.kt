package com.example.titresresto.listanddetails.feature.domain.model

import androidx.room.Embedded

data class Amount(
    val value : Double,
    @Embedded val currency : Currency
)
