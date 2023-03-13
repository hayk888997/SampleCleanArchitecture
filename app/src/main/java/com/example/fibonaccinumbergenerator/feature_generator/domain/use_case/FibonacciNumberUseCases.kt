package com.example.fibonaccinumbergenerator.feature_generator.domain.use_case

data class FibonacciNumberUseCases(
    val getFibonacciNumbers: GetFibonacciNumbersUseCase,
    val generateFibonacciNumber: GenerateFibonacciNumberUseCase
)