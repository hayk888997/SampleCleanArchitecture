package com.example.fibonaccinumbergenerator.feature_generator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.fibonaccinumbergenerator.databinding.ActivityMainBinding
import com.example.fibonaccinumbergenerator.feature_generator.presentation.adapter.FibonacciNumbersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GeneratorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<GeneratorViewModel>()
    private val adapter = FibonacciNumbersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerate.setOnClickListener {
            viewModel.onEvent(GeneratorEvents.GenerateNewFibonacciNumber)
        }
        binding.rvHistory.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.state.collect {
                it.generatedFibonacciNumber?.let { binding.tvGeneratedNumber.text = it.toString() }
                adapter.submitList(viewModel.state.value.history) {
                    binding.rvHistory.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
}