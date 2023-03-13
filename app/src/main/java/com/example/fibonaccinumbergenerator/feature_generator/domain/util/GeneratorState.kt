package com.example.fibonaccinumbergenerator.feature_generator.domain.util

import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber

data class GeneratorState(
    val generatedFibonacciNumber: Long? = null,
    val history: List<FibonacciNumber>? = null,
    )