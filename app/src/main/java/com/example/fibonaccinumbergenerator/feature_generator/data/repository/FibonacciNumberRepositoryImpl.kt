package com.example.fibonaccinumbergenerator.feature_generator.data.repository

import com.example.fibonaccinumbergenerator.feature_generator.data.data_source.FibonacciNumberDao
import com.example.fibonaccinumbergenerator.feature_generator.data.mapper.toFibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.data.mapper.toFibonacciNumberRoom
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.FibonacciNumber
import com.example.fibonaccinumbergenerator.feature_generator.domain.repository.FibonacciNumberRepository
import kotlinx.coroutines.flow.*

class FibonacciNumberRepositoryImpl(
    private val dao: FibonacciNumberDao
) : FibonacciNumberRepository {
    override fun getFibonacciNumbers(): Flow<List<FibonacciNumber>> {
        val roomFLow = dao.getFibonacciNumbersHistory()
        return roomFLow.map { fibonacciRoomList ->
            fibonacciRoomList.map { fibonacciRoom ->
                fibonacciRoom.toFibonacciNumber()
            }
        }
    }

    override suspend fun insertFibonacciNumber(fibonacciNumber: FibonacciNumber) {
        return dao.insertFibonacciNumber(fibonacciNumber.toFibonacciNumberRoom())
    }
}