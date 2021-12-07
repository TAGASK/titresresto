package com.example.titresresto.listanddetails.feature.presenter.list.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import java.text.DateFormatSymbols

@Composable
fun TransactionHeader(
    month: Int,
    cornerRadius: Dp = 10.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.background(Color.White)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {
            Text(
                text = toMonthString(month = month),
                color = Color.LightGray,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .testTag("month")
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

}

fun toMonthString(month: Int): String {
    return if(month in 0..11) {
        DateFormatSymbols().months[month]
    } else {
        ""
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionHeaderPreview() {
    TitresRestoAppTheme {
        TransactionHeader(month = 1)
    }
}