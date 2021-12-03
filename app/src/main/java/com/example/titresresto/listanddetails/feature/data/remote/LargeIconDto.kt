package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.LargeIcon
import com.google.gson.annotations.SerializedName

data class LargeIconDto(
    @SerializedName("url"      ) var url      : String,
    @SerializedName("category" ) var category : String
) {
    fun toIcon(): LargeIcon {
        return  LargeIcon(
            url = url,
            category = category
        )
    }
}
