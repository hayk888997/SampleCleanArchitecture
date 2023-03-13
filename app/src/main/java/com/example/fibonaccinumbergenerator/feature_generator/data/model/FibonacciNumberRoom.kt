package com.example.fibonaccinumbergenerator.feature_generator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "fibonacciNumbers"
)
data class FibonacciNumberRoom(
    val number: Long,
    val timeStamp: Long,
    @PrimaryKey val id: Int? = null
)