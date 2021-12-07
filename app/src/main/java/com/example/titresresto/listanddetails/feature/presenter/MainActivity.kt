package com.example.titresresto.listanddetails.feature.presenter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.titresresto.listanddetails.feature.TitresRestoAppTheme
import com.example.titresresto.listanddetails.feature.presenter.details.DetailsTransactionScreen
import com.example.titresresto.listanddetails.feature.presenter.list.ListTransactionScreen
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalFoundationApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitresRestoAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.listTransactionScreen.route
                    )
                    {
                        composable(
                            route = Screen.listTransactionScreen.route
                        ) {
                            ListTransactionScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = Screen.detailsTransactionScreen.route + "/{id}",
                            arguments = listOf(
                                navArgument(
                                    name = "id"
                                ) {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            it.arguments?.getInt("id")?.let { it1 ->
                                DetailsTransactionScreen(
                                    id = it1,
                                    navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}