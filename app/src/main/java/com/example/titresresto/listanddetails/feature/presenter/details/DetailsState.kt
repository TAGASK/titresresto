package com.example.titresresto.listanddetails.feature.presenter.details

import com.example.titresresto.listanddetails.feature.domain.model.Transaction

data class DetailsState (
    val transaction: Transaction? = null,
    val isVisible : Boolean = false
)