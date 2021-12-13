package com.example.titresresto.listanddetails.feature.presenter.details.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.titresresto.R
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.presenter.CategoryObject

@Composable
fun CallToActionItem(
    icon: CategoryObject,
    title: String,
    option: String?,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            var modifierLargeImage = Modifier
                .size(75.dp)
                .border(16.dp, Color.White, RoundedCornerShape(32.dp))
                .clip(RoundedCornerShape(32.dp))
                .background(icon.background)
                .padding(25.dp)
            var colorF: ColorFilter? = null
            ColorFilter.lighting(
                multiply = icon.foreground,
                add = icon.foreground
            ).also { colorF = it }
            Image(
                painter = rememberImagePainter(
                    data = icon.idResource,
                ),
                colorFilter = colorF,
                contentDescription = "thumbnailUrl",
                modifier = modifierLargeImage
            )
        }
        Text(
            text = String.format("%s", title),
            color = Color(0xFF2B2152),
            fontSize = 15.sp,
            modifier = Modifier.weight(2f)
        )
        val paragraphStyle1 = ParagraphStyle(
           textAlign = TextAlign.End
        )
        Text(
            text = buildAnnotatedString {
                append(String.format("%s", option))
                option?.length?.let { addStyle(paragraphStyle1, 0, it) }
            },
            color = Color(0xFF6346D0),
            fontSize = 12.sp,
            modifier = Modifier.weight(1f).padding(end = 30.dp)
        )

    }
    Divider(color = Color(0xFFEEEDF1),
        thickness = 1.dp,
        modifier = Modifier.padding(start = 100.dp,
        end = 50.dp))
}


@Preview
@Composable
fun CallToActionItem() {
    TitresRestoAppTheme {
        val primaryGray = 0xCC918CA5
        val secondaryGray = 0xCCF6F6F8
        CallToActionItem(
            CategoryObject(
                R.drawable.ic_vector_heart,
                "Brasserie", Color(primaryGray),
                Color(secondaryGray)
            ), title = "Aimer", option = ""
        )
    }
}