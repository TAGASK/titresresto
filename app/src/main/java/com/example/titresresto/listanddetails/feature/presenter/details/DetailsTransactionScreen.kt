package com.example.titresresto.listanddetails.feature.presenter.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.domain.model.Amount
import com.example.titresresto.listanddetails.feature.presenter.details.composable.AmountText
import com.example.titresresto.listanddetails.feature.presenter.details.composable.DetailsHeader


@Composable
fun DetailsTransactionScreen(
    id: String,
    navController: NavController,
    viewModel: TransactionDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    viewModel.getTransaction(Integer.valueOf(id))
    if (state.isVisible) {
        state.transaction?.let {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxSize()) {

                DetailsHeader(
                    imageUrl = it.largeIcon.urlLI,
                    category = it.largeIcon.categoryLI
                )


            }

            AmountText(amount = it.amount, 34.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            it.message?.let { message ->
                Text(text = message,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            Text(
                text = it.getDateAsDetailsLabel(),
                fontSize = 13.sp,
                color = Color.LightGray,
                modifier = Modifier.padding(start = 2.dp, end = 16.dp)
            )

        }
        }

    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            CircularProgressIndicator(color = Color.Cyan)
        }
    }

}
