package com.example.titresresto.listanddetails.feature.domain.usecases

import com.example.base.tools.data.Resource
import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionDetailsUsecase @Inject constructor(
    val repository: TransactionRepository
) {
    operator fun invoke(id : Int) : Flow<Resource<Transaction>> {
        return repository.getTransaction(id)
    }
}