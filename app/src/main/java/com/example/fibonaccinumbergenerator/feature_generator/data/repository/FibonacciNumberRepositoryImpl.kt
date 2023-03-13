package com.example.fibonaccinumbergenerator.feature_generator.data.repository

import com.example.fibonaccinumbergenerator.feature_generator.data.data_source.FibonacciNumberDao
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.domain.repository.FibonacciNumberRepository
import kotlinx.coroutines.flow.Flow

class FibonacciNumberRepositoryImpl(
    private val dao: FibonacciNumberDao
) : FibonacciNumberRepository {
    override fun getFibonacciNumbers(): Flow<List<FibonacciNumber>> {
        return dao.getFibonacciNumbersHistory()
    }

    override suspend fun insertFibonacciNumber(fibonacciNumber: FibonacciNumber) {
        return dao.insertFibonacciNumber(fibonacciNumber)
    }
}