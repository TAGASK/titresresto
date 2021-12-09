package com.example.titresresto.listanddetails.feature.data.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.titresresto.listanddetails.feature.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Query("SELECT * FROM `transactions`")
    fun getTransactions(): Flow<List<Transaction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(transactions : List<Transaction>)

    @Query("SELECT * FROM `transactions` WHERE `index`=:id")
    fun getTransaction(id: Int): Flow<Transaction>

}