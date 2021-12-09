package com.example.titresresto.listanddetails.feature.domain.repository

import com.example.base.tools.data.Resource
import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getTransactions() : Flow<Resource<List<Transaction>>>

    suspend fun insertAll(transactions : List<Transaction>)

    fun getTransaction(id: Int): Flow<Resource<Transaction>>

}