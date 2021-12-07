package com.example.titresresto.listanddetails.feature.presenter.list.composable

import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.domain.model.Amount
import com.example.titresresto.listanddetails.feature.domain.model.Currency

@Composable
fun AmountText(
    amount : Amount,
    fontSize : TextUnit = TextUnit.Unspecified,
    modifier : Modifier = Modifier
) {
    if(amount.value > 0) {
        Text(
            text = String.format(" +%.2f %s ", amount.value, amount.currency.symbol),
            color = Color(0XFF8169D9),
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            modifier = modifier.wrapContentWidth()
                .background(color =  Color(0XFFE6E0F7), shape = RoundedCornerShape(5.dp) )
        )
    } else {
        Text(
            text = String.format("%.2f %s", amount.value, amount.currency.symbol),
            color = Color.Black,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmountTextPreview() {
    TitresRestoAppTheme {
        AmountText(amount = Amount(1.2, Currency("EUR", "€", "Euro")))
    }
}