package com.example.fibonaccinumbergenerator.feature_generator.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import kotlinx.coroutines.flow.Flow

@Dao
interface FibonacciNumberDao {
    @Query("SELECT * FROM fibonacciNumbers")
    fun getFibonacciNumbersHistory(): Flow<List<FibonacciNumber>>

    @Insert
    suspend fun insertFibonacciNumber(fibonacciNumber: FibonacciNumber)
}