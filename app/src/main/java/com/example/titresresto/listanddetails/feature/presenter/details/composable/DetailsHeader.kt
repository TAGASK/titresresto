package com.example.titresresto.listanddetails.feature.presenter.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.domain.model.Amount
import com.example.titresresto.listanddetails.feature.presenter.Category
import com.example.titresresto.listanddetails.feature.presenter.CategoryConstants
import com.example.titresresto.listanddetails.feature.presenter.details.DetailsTransactionScreen

@Composable
fun DetailsHeader(
    imageUrl : String?,
    category :  String?,
    modifier : Modifier = Modifier
){
    val pair = Category.selectIcon(category)
    var colorF : ColorFilter? = null
    if(imageUrl == null) {
        ColorFilter.lighting(
            multiply = pair.foreground,
            add = pair.foreground
        ).also { colorF = it }
    }
    Box(modifier = modifier.fillMaxWidth()
        .background(pair.background)
        .height(224.dp),
        contentAlignment = Alignment.Center) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl ?: pair.idResource,
            ),
            alpha = 1.0F,
            colorFilter = colorF,
            contentDescription = "thumbnailUrl",
            modifier = Modifier
                .size(100.dp)
        )
    }

}

@Preview
@Composable
fun DetailsHeaderPreview(){
    TitresRestoAppTheme {
        DetailsHeader(null,
            CategoryConstants.GIFT)
    }
}