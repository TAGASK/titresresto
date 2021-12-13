package com.example.titresresto.listanddetails.feature.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.titresresto.listanddetails.feature.data.locale.TransactionDao
import com.example.titresresto.listanddetails.feature.data.locale.TransactionDataBase
import com.example.titresresto.listanddetails.feature.domain.model.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(RobolectricTestRunner::class)
class TransactionDaoUnitTest {

    private lateinit var database: TransactionDataBase
    private lateinit var transactionDao: TransactionDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TransactionDataBase::class.java
        )
            .allowMainThreadQueries()
            .build()

        transactionDao = database.transactionDao

    }

    @Test
    fun saveTransaction_retrieveTransaction() = runBlocking<Unit> {
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
            ))
        transactionDao.insertAll(listOf(transaction))

        val res = transactionDao.getTransactions()
        val resTransaction = res.first()
        assertEquals(transaction.name, resTransaction[0].name)
        assertEquals(transaction.type, resTransaction[0].type)
        assertEquals(transaction.date, resTransaction[0].date)
        assertEquals(transaction.message, resTransaction[0].message)
        assertEquals(transaction.amount.value, resTransaction[0].amount.value)
        assertEquals(transaction.amount.currency.iso3, resTransaction[0].amount.currency.iso3)
        assertEquals(transaction.amount.currency.symbol, resTransaction[0].amount.currency.symbol)
        assertEquals(transaction.amount.currency.title, resTransaction[0].amount.currency.title)
        assertEquals(transaction.smallIcon.categorySI, resTransaction[0].smallIcon.categorySI)
        assertEquals(transaction.smallIcon.urlSI, resTransaction[0].smallIcon.urlSI)
        assertEquals(transaction.largeIcon.categoryLI, resTransaction[0].largeIcon.categoryLI)
        assertEquals(transaction.largeIcon.urlLI, resTransaction[0].largeIcon.urlLI)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }
}