package com.example.titresresto.listanddetails.feature.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "transactions", indices = [Index(value = ["index"], unique = true)])
data class Transaction(
    val name : String? = null,
    val type : String? = null,
    val date : String? = null,
    val message : String? = null,
    @Embedded val amount : Amount,
    @Embedded val smallIcon : SmallIcon,
    @Embedded val largeIcon : LargeIcon,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var index: Int = (name + type + date + message + String.format("%f",amount.value)).hashCode()

    fun getDateAsDate() : Date {
        val dtStart = date
        var dateTmp = Date()
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        try {
            format.timeZone = TimeZone.getTimeZone("GMT");
            dateTmp =  format.parse(dtStart)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return dateTmp
    }

    fun getDateAsListLabel(): String {
        val dateDate = getDateAsDate()
        val format = SimpleDateFormat("d MMMM")
        val ret: String = format.format(dateDate)
        return ret
    }

    fun getDateAsDetailsLabel(): String {
        val dateDate = getDateAsDate()
        val format = SimpleDateFormat("E dd MMMM, HH:mm")
        val ret: String = format.format(dateDate)
        return ret
    }
}
