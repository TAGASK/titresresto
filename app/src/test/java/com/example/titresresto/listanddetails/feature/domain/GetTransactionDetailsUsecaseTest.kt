package com.example.titresresto.listanddetails.feature.domain

import com.example.titresresto.listanddetails.feature.data.FakeTransactionRepository
import com.example.titresresto.listanddetails.feature.domain.model.*
import com.example.titresresto.listanddetails.feature.domain.model.Currency
import com.example.titresresto.listanddetails.feature.domain.repository.TransactionRepository
import com.example.titresresto.listanddetails.feature.domain.usecases.GetTransactionDetailsUsecase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class GetTransactionDetailsUsecaseTest {

    private lateinit var getTransactions: GetTransactionDetailsUsecase
    private lateinit var repository: TransactionRepository

    @Before
    fun setup() {
        repository = FakeTransactionRepository()
        getTransactions = GetTransactionDetailsUsecase(repository)
    }

    @Test
    fun `Transactions Details return if present`(): Unit = runBlocking {
        val transaction = Transaction(
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

        repository.insertAll(Collections.singletonList(transaction))

        val returnListFlow = getTransactions.invoke(transaction.index)
        val returnList = returnListFlow.first()
        returnList.data?.let {
                Assert.assertEquals(transaction.name, it.name)
                Assert.assertEquals(transaction.id, it.id)
                Assert.assertEquals(transaction.message, it.message)
                Assert.assertEquals(transaction.type, it.type)
        }

    }
}