package com.example.titresresto.listanddetails.feature.data.repository

import com.example.base.tools.data.Resource
import com.example.base.tools.data.performGetOperation
import com.example.titresresto.listanddetails.feature.data.locale.TransactionDataBase
import com.example.titresresto.listanddetails.feature.data.remote.TransactionDataSource
import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(
    private val dataBase: TransactionDataBase,
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override fun getTransactions() = performGetOperation(
        databaseQuery = { dataBase.transactionDao.getTransactions()},
        networkCall = { transactionDataSource.getTransactions() },
        saveCallResult = {
            dataBase.transactionDao.insertAll(
                it.map { data ->
                    data.toTransaction()
                }
            )
        }
    )

    override suspend fun insertAll(transactions: List<Transaction>) {
        TODO("Not yet implemented")
    }
}