package com.example.fibonaccinumbergenerator.feature_generator.domain.use_case

import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.InvalidFibonacciNumberException
import com.example.fibonaccinumbergenerator.feature_generator.domain.repository.FibonacciNumberRepository
import com.example.fibonaccinumbergenerator.feature_generator.domain.util.generateRandomFibonacciNumber

class GenerateFibonacciNumberUseCase(
    private val repository: FibonacciNumberRepository
) {
    @Throws(InvalidFibonacciNumberException::class)
    suspend operator fun invoke(): FibonacciNumber {
        val newFibonacciNumber = FibonacciNumber(generateRandomFibonacciNumber(), System.currentTimeMillis())
        repository.insertFibonacciNumber(newFibonacciNumber)
        return newFibonacciNumber
    }
}