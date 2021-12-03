package com.example.titresresto.listanddetails.feature.domain.model

import androidx.room.Embedded
import androidx.room.PrimaryKey

data class Transaction(
    val name : String,
    val type : String,
    val date : String,
    val message : String,
    @Embedded val amount : Amount,
    @Embedded val smallIcon : SmallIcon,
    @Embedded val largeIcon : LargeIcon,
) {
    @PrimaryKey(autoGenerate = true)
    private val id: Int? = null
}
