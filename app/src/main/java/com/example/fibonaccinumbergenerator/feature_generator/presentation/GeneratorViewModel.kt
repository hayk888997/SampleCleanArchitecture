package com.example.fibonaccinumbergenerator.feature_generator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fibonaccinumbergenerator.feature_generator.domain.model.InvalidFibonacciNumberException
import com.example.fibonaccinumbergenerator.feature_generator.domain.use_case.FibonacciNumberUseCases
import com.example.fibonaccinumbergenerator.feature_generator.domain.util.GeneratorState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class GeneratorViewModel(
    private val useCases: FibonacciNumberUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(GeneratorState())
    val state: StateFlow<GeneratorState> = _state

    private var getFibonacciNumbersHistory: Job? = null

    init {
        getFibonacciNumbersHistory()
    }

    fun onEvent(event: GeneratorEvents) {
        when (event) {
            is GeneratorEvents.GenerateNewFibonacciNumber -> {
                viewModelScope.launch {
                    try {
                        val randomFibonacci = useCases.generateFibonacciNumber()
                        _state.value =
                            _state.value.copy(generatedFibonacciNumber = randomFibonacci.number)
                    } catch (ex: InvalidFibonacciNumberException) {
                        // TODO: In reality such a case can't happen, it's just a demonstration of
                        // exception handling, where we can add extra field in state flow or have
                        // separated flow for such cases
                    }
                }
            }
        }
    }

    private fun getFibonacciNumbersHistory() {
        getFibonacciNumbersHistory?.cancel()
        getFibonacciNumbersHistory = useCases.getFibonacciNumbers()
            .onEach { history ->
                _state.value = state.value.copy(
                    history = history
                )
            }
            .launchIn(viewModelScope)
    }
}