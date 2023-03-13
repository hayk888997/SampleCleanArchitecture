package com.example.fibonaccinumbergenerator.feature_generator.domain.use_case

import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.domain.repository.FibonacciNumberRepository
import kotlinx.coroutines.flow.Flow

class GetFibonacciNumbersUseCase(
    private val repository: FibonacciNumberRepository
) {
    operator fun invoke(): Flow<List<FibonacciNumber>> {
        return repository.getFibonacciNumbers()
    }
}