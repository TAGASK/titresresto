package com.example.titresresto.listanddetails.feature.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.titresresto.listanddetails.feature.domain.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1
)
abstract class TransactionDataBase : RoomDatabase() {

    abstract val transactionDao : TransactionDao

    companion object {
        const val DATABASE_NAME = "transactions_db"
    }
}