package com.example.titresresto.listanddetails.feature.presenter.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.titresresto.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.titresresto.listanddetails.feature.presenter.Category
import com.example.titresresto.listanddetails.feature.presenter.CategoryObject
import com.example.titresresto.listanddetails.feature.presenter.details.composable.AmountText
import com.example.titresresto.listanddetails.feature.presenter.details.composable.CallToActionItem
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
                val categoryObject = Category.selectIcon(state.transaction.largeIcon.categoryLI)
                Box(modifier = Modifier.fillMaxWidth()) {

                    DetailsHeader(
                        imageUrl = it.largeIcon.urlLI,
                        category = it.largeIcon.categoryLI
                    )


                }
                Spacer(Modifier.height(24.dp))
                AmountText(
                    amount = it.amount,
                    34.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = state.transaction.message ?: categoryObject.name,
                    color = Color.Black,
                    fontSize = 13.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = it.getDateAsDetailsLabel(),
                    fontSize = 13.sp,
                    color = Color.LightGray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(8.dp))
                val primaryOrange = 0xCCFFEBD4
                val secondaryOrange = 0xCCFB9C3A
                val primaryGray = 0xCC918CA5
                val secondaryGray = 0xCCF6F6F8
                CallToActionItem(
                    CategoryObject(R.drawable.ic_vector_fork_knife,
                        "Brasserie"
                        , Color(primaryOrange),
                        Color(secondaryOrange))
                    , title = "Titre resto", option = "Changer\n de compte" )
                Spacer(Modifier.height(8.dp))
                CallToActionItem(
                    CategoryObject(R.drawable.ic_vector_share,
                        "Brasserie"
                        , Color(primaryGray),
                        Color(secondaryGray)), title = "Partage d'addition" , option = "" )
                Spacer(Modifier.height(8.dp))
                CallToActionItem(
                    CategoryObject(R.drawable.ic_vector_heart,
                        "Brasserie"
                        , Color(primaryGray),
                        Color(secondaryGray)), title = "Aimer" , option = "" )
                Spacer(Modifier.height(8.dp))
                CallToActionItem(
                    CategoryObject(R.drawable.ic_vector_question_mark,
                        "Brasserie"
                        , Color(primaryGray),
                        Color(secondaryGray)), title = "Signaler un problème" , option = "" )
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
