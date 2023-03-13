package com.example.fibonaccinumbergenerator.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fibonaccinumbergenerator.feature_generator.data.data_source.FibonacciNumbersDataBase
import com.example.fibonaccinumbergenerator.feature_generator.data.data_source.FibonacciNumbersDataBase_Impl
import com.example.fibonaccinumbergenerator.feature_generator.data.repository.FibonacciNumberRepositoryImpl
import com.example.fibonaccinumbergenerator.feature_generator.domain.repository.FibonacciNumberRepository
import com.example.fibonaccinumbergenerator.feature_generator.domain.use_case.FibonacciNumberUseCases
import com.example.fibonaccinumbergenerator.feature_generator.domain.use_case.GetFibonacciNumbersUseCase
import com.example.fibonaccinumbergenerator.feature_generator.domain.use_case.GenerateFibonacciNumberUseCase
import com.example.fibonaccinumbergenerator.feature_generator.presentation.GeneratorViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {
    //Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            FibonacciNumbersDataBase::class.java,
            FibonacciNumbersDataBase.DATABASE_NAME
        ).build()
    }

    //DB
    single<RoomDatabase> { FibonacciNumbersDataBase_Impl() }
    //DAO
    single {
        val database = get<FibonacciNumbersDataBase>()
        database.fibonacciNumberDao
    }
    //Repositories
    single<FibonacciNumberRepository> { FibonacciNumberRepositoryImpl(get()) }

    //UseCases
    single {
        FibonacciNumberUseCases(
            GetFibonacciNumbersUseCase(get()),
            GenerateFibonacciNumberUseCase(get())
        )
    }

    //viewModels
    viewModel { GeneratorViewModel(get()) }

}