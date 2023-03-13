package com.example.fibonaccinumbergenerator.feature_generator.domain.model

data class FibonacciNumber(
    val number: Long,
    val timeStamp: Long,
)

class InvalidFibonacciNumberException(message: String) : Exception(message)