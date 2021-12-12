package com.example.titresresto.listanddetails.feature.presenter.list.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.titresresto.R
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.domain.model.*
import com.example.titresresto.listanddetails.feature.presenter.Category
import com.example.titresresto.listanddetails.feature.presenter.CategoryConstants

@Composable
fun TransactionItem(
    onClick: () -> Unit,
    transaction: Transaction,
    cornerRadius: Dp = 10.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(
                start = 2.dp,
                end = 2.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val obj = Category.selectIcon(transaction.largeIcon.categoryLI)
            Box(
                modifier = Modifier.weight(1f)
            ) {

                Box(modifier = Modifier.align(Alignment.Center)) {
                    // Advanced

                    var colorF : ColorFilter? = null
                    var modifierLargeImage = Modifier
                        .size(90.dp)
                        .padding(16.dp)
                        .border(1.dp, Color.LightGray, RoundedCornerShape(25.dp))
                        .clip(RoundedCornerShape(25.dp))
                    if(transaction.largeIcon.urlLI == null) {
                        modifierLargeImage = Modifier
                            .size(90.dp)
                            .border(16.dp, Color.White, RoundedCornerShape(38.dp))
                            .clip(RoundedCornerShape(38.dp))
                            .background(obj.background)
                            .padding(25.dp)

                        ColorFilter.lighting(
                            multiply = obj.foreground,
                            add = obj.foreground
                        ).also { colorF = it }
                    }
                    Image(
                        painter = rememberImagePainter(
                            data = transaction.largeIcon.urlLI
                                ?: obj.idResource,
                        ),
                        colorFilter = colorF,
                        contentDescription = "thumbnailUrl",
                        modifier = modifierLargeImage
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(
                            bottom = 15.dp,
                            end = 18.dp
                        )
                ) {
                    val obj = Category.selectIcon(transaction.smallIcon.categorySI)
                    Image(
                        painter = rememberImagePainter(
                            data = obj.idResource,
                            builder = {
                                transformations(CircleCropTransformation())
                            }
                        ),
                        alpha = 1.0F,
                        colorFilter = ColorFilter.lighting(obj.foreground,
                            obj.foreground),
                        contentDescription = "thumbnailUrl",
                        modifier = Modifier
                            .size(25.dp)
                            .border(3.dp, Color.White, CircleShape)
                            .padding(3.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                }

            }

            Column(modifier = Modifier.weight(2f)) {
                Text(
                    text = String.format("%s", transaction.message ?: obj.name),
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 2.dp, end = 16.dp)
                )
                Text(
                    text = transaction.getDateAsListLabel(),
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(start = 2.dp, end = 16.dp)
                )
            }
            transaction.amount?.let {
                AmountText(
                    amount = it,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .width(220.dp)
                        .weight(1f)
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AlbumItemPreview() {
    TitresRestoAppTheme {
        TransactionItem(
            onClick = {},
            transaction = Transaction(
                name = "name",
                type = "donation",
                date = "2021-03-07T14:04:45.000+01:00",
                message = "Don à l'arrondi",
                amount = Amount(
                    value = 0.07,
                    currency = Currency(
                        iso3 = "EUR",
                        symbol = "€",
                        title = "Euro"
                    )
                ),
                smallIcon = SmallIcon(
                    urlSI = "https://res.cloudinary.com/hbnjrwllw/image/upload/v1583240999/neobank/charity/cdaa7851-da33-4b3c-8e01-228c4b085ac3.png",
                    categorySI = "donation"
                ),
                largeIcon = LargeIcon(
                    urlLI = "https://res.cloudinary.com/hbnjrwllw/image/upload/v1583240999/neobank/charity/cdaa7851-da33-4b3c-8e01-228c4b085ac3.png",
                    categoryLI = "donation"
                ),

                )
        )
    }
}

