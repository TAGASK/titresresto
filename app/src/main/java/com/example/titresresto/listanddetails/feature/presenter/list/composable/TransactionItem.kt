package com.example.titresresto.listanddetails.feature.presenter.list.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.titresresto.R
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.domain.model.*

@Composable
fun TransactionItem(
    onClick: () -> Unit,
    transaction: Transaction,
    cornerRadius: Dp = 10.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.clickable(onClick = onClick).padding(
            start = 2.dp,
            end = 2.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            // Advanced
            Image(
                painter = rememberImagePainter(
                    data = transaction.smallIcon.urlSI
                        ?: R.drawable.ic_launcher_background,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "thumbnailUrl",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
                    .weight(1f)
            )
            Column( modifier = Modifier.weight(2f)) {
                Text(
                    text = String.format("%s", transaction.message),
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
                AmountText(amount = it,
                    fontSize = 14.sp,
                    modifier = Modifier.width(220.dp)
                        .weight(1f))
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

