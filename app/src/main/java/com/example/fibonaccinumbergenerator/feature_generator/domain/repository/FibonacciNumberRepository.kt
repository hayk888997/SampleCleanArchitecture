package com.example.fibonaccinumbergenerator.feature_generator.domain.repository

import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import kotlinx.coroutines.flow.Flow

interface FibonacciNumberRepository {
    fun getFibonacciNumbers(): Flow<List<FibonacciNumber>>
    suspend fun insertFibonacciNumber(fibonacciNumber: FibonacciNumber)
}