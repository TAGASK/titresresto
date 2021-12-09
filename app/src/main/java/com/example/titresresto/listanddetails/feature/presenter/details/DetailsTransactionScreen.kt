package com.example.titresresto.listanddetails.feature.presenter.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun DetailsTransactionScreen(
    id: String,
    navController: NavController,
    viewModel: TransactionDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    viewModel.getTransaction(Integer.valueOf(id))
    if (state.isVisible) {
        Box(modifier = Modifier.fillMaxSize()) {
            state.transaction?.let {
            Text(
                 String.format("This text is drawn first : %s", it.message),
                color = Color.Black,
                modifier = Modifier.align(Alignment.TopCenter)
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
