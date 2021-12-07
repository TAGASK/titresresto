package com.example.titresresto.listanddetails.feature.presenter

sealed class Screen(val route: String) {
    object listTransactionScreen : Screen("list_transaction_screen")
    object detailsTransactionScreen : Screen("details_transaction_screen")
}