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
                        startDestination = Screen.ListTransactionScreen.route
                    )
                    {
                        composable(
                            route = Screen.ListTransactionScreen.route
                        ) {
                            ListTransactionScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = Screen.DetailsTransactionScreen.route + "/{id}",
                            arguments = listOf(
                                navArgument(
                                    name = "id"
                                ) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            it.arguments?.getString("id")?.let { it1 ->
                                DetailsTransactionScreen(
                                    id = it1,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}