package com.example.titresresto.listanddetails.feature.domain

import com.example.titresresto.listanddetails.feature.data.FakeTransactionRepository
import com.example.titresresto.listanddetails.feature.domain.model.*
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionDetailsUsecase
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetTransactionUsecaseTest {

    private lateinit var getTransactions: GetTransactionUseCase
    private lateinit var repository: TransactionRepository

    @Before
    fun setup() {
        repository = FakeTransactionRepository()
        getTransactions = GetTransactionUseCase(repository)
    }

    @Test
    fun `Transactions return if present`(): Unit = runBlocking {
        val transactionList = mutableListOf<Transaction>()
        for (i in 0..5) {
            transactionList.add(
                Transaction(
                    name = "name",
                    type = "donation",
                    date = "2021-03-07T14:04:45.000+01:00",
                    message = "Don à l'arrondi",
                    amount = Amount(
                        value = 0.07,
                        currency = Currency(
                            iso3 = "EUR",
                            symbol = "€",
                            title = "Euro"
                        )
                    ),
                    smallIcon = SmallIcon(
                        urlSI = "https://res.cloudinary.com/hbnjrwllw/image/upload/v1583240999/neobank/charity/cdaa7851-da33-4b3c-8e01-228c4b085ac3.png",
                        categorySI = "donation"
                    ),
                    largeIcon = LargeIcon(
                        urlLI = "https://res.cloudinary.com/hbnjrwllw/image/upload/v1583240999/neobank/charity/cdaa7851-da33-4b3c-8e01-228c4b085ac3.png",
                        categoryLI = "donation"
                    )
                )
            )
        }
        repository.insertAll(transactionList)

        val returnListFlow = getTransactions.invoke()
        val returnList = returnListFlow.first()
        returnList.data?.let {
            for (i in it!!.indices) {
                Assert.assertEquals(transactionList[0].name, it[i].name)
                Assert.assertEquals(transactionList[0].id, it[i].id)
                Assert.assertEquals(transactionList[0].message, it[i].message)
                Assert.assertEquals(transactionList[0].type, it[i].type)
            }
        }

    }

}