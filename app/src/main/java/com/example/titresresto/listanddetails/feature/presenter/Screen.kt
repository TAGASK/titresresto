package com.example.titresresto.listanddetails.feature.presenter

sealed class Screen(val route: String) {
    object ListTransactionScreen : Screen("list_transaction_screen")
    object DetailsTransactionScreen : Screen("details_transaction_screen")

    fun withArgs(vararg args: String): String
    {
        return buildString {
                append(route)
                args.forEach { arg ->
                    append("/$arg")
                }
        }
    }
}