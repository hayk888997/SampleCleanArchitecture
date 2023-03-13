package com.example.fibonaccinumbergenerator.feature_generator.data.mapper

import com.example.fibonaccinumbergenerator.feature_generator.data.model.FibonacciNumberRoom
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber

fun FibonacciNumberRoom.toFibonacciNumber(): FibonacciNumber {
    return FibonacciNumber(
        number = number,
        timeStamp = timeStamp
    )
}

fun FibonacciNumber.toFibonacciNumberRoom(): FibonacciNumberRoom {
    return FibonacciNumberRoom(number = number, timeStamp = timeStamp)
}