package com.example.titresresto.listanddetails.feature.data.remote

import com.example.titresresto.listanddetails.feature.domain.model.LargeIcon
import com.google.gson.annotations.SerializedName

data class LargeIconDto(
    @SerializedName("url") var url: String? = null,
    @SerializedName("category") var category: String? = null
) {
    fun toIcon(): LargeIcon {
        return LargeIcon(
            urlLI = url,
            categoryLI = category
        )
    }
}
