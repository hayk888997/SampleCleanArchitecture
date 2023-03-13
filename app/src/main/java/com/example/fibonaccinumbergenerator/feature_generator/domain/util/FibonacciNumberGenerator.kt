package com.example.fibonaccinumbergenerator.feature_generator.domain.util

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

val PHI = (sqrt(5.0) + 1.0) / 2.0
private const val HIGHEST_POSITION_OF_FIBONACCI_NUMBER_FOR_LONG = 91

//In case there is a requirement to have randomness in bigger range, other data type should be used,
// like BigInteger, but that might cause memory issues, so be careful with what you choose

// Binet's formula is used
fun generateRandomFibonacciNumber(): Long {
    val index = Random.nextInt(0, HIGHEST_POSITION_OF_FIBONACCI_NUMBER_FOR_LONG)

    return ((PHI.pow(index.toDouble()) - (1.0 - PHI).pow(index.toDouble())) / sqrt(5.0)).toLong()
}
