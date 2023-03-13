package com.example.fibonaccinumbergenerator.feature_generator.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "fibonacciNumbers"
)
data class FibonacciNumber(
    val number: Long,
    val timeStamp: Long,
    @PrimaryKey val id: Int? = null
)

class InvalidFibonacciNumberException(message : String) : Exception(message)