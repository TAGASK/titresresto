package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.SmallIcon
import com.google.gson.annotations.SerializedName

data class SmallIconDto(
    @SerializedName("url"      ) var url      : String,
    @SerializedName("category" ) var category : String
) {
    fun toIcon(): SmallIcon {
        return SmallIcon(
            url = url,
            category = category
        )
    }
}
