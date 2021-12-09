package com.example.titresresto.listanddetails.feature.presenter.list

import com.example.titresresto.listanddetails.feature.domain.model.Transaction

data class ListState(
    val grouped: Map<Int, List<Transaction>> = emptyMap(),
    val isVisible : Boolean = false
)
