package com.example.titresresto.listanddetails.feature.data

import com.example.base.tools.data.Resource
import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.function.Consumer

class FakeTransactionRepository : TransactionRepository {

    private val transactions = mutableListOf<Transaction>()

    override fun getTransactions(): Flow<Resource<List<Transaction>>> {
       return flow {
           emit(Resource.success(transactions))
       }
    }

    override suspend fun insertAll(transactions: List<Transaction>) {
        this.transactions.addAll(transactions)
    }

    override fun getTransaction(id: Int): Flow<Resource<Transaction>> {
        return flow {
            var transaction : Transaction? = null
            transactions.forEach(Consumer {
                if(it.index == id) {
                   transaction = it
                    return@Consumer
                }
            })
            transaction?.let {
                emit(value = Resource.success(it))
            }
        }
    }
}