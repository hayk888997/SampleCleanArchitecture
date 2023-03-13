package com.example.fibonaccinumbergenerator.feature_generator.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fibonaccinumbergenerator.feature_generator.data.model.FibonacciNumberRoom

@Database(
    entities = [FibonacciNumberRoom::class],
    version = 1
)
abstract class FibonacciNumbersDataBase : RoomDatabase() {
    abstract val fibonacciNumberDao: FibonacciNumberDao

    companion object {
        const val DATABASE_NAME = "fibonacci_numbers_db"
    }
}