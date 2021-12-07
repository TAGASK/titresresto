package com.example.titresresto.listanddetails.feature.presenter

import com.example.titresresto.listanddetails.feature.domain.model.Transaction

data class ListState(
    val grouped: Map<Int, List<Transaction>> = emptyMap(),
    val isTransactionListVisible : Boolean = false
)
