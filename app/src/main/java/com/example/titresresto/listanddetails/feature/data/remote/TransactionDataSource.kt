package com.example.titresresto.listanddetails.feature.data.remote

import com.example.base.data.remote.BaseDataSource
import javax.inject.Inject

class TransactionDataSource @Inject constructor(
    private val transactionService: TransactionService
) : BaseDataSource() {
    suspend fun getTransactions() = getResult { transactionService.getTransactions() }
}