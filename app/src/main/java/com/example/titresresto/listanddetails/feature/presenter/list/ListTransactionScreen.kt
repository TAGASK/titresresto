package com.example.titresresto.listanddetails.feature.presenter.list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.titresresto.listanddetails.feature.presenter.Screen
import com.example.titresresto.listanddetails.feature.presenter.TransactionsViewModel
import com.example.titresresto.listanddetails.feature.presenter.list.composable.TransactionHeader
import com.example.titresresto.listanddetails.feature.presenter.list.composable.TransactionItem


@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ListTransactionScreen(
    navController: NavController,
    viewModel: TransactionsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isTransactionListVisible) {
            // Remember our own LazyListState
            val listState = rememberLazyListState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .testTag("list")) {
                    state.grouped.forEach { (month, transaction) ->
                        stickyHeader() {
                            TransactionHeader(
                                month = month
                            )
                        }

                        items(transaction) { it ->
                            TransactionItem(
                                transaction = it,
                                modifier = Modifier.selectable(selected = false, enabled = true,
                                    onClick = {
                                        navController.navigate(
                                            route = Screen.detailsTransactionScreen.route + "/" + it.id
                                        )
                                    })
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
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

}