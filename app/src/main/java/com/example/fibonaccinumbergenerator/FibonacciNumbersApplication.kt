package com.example.fibonaccinumbergenerator

import android.app.Application
import com.example.fibonaccinumbergenerator.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FibonacciNumbersApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(koinModule)
            // Use Koin Android Logger
            androidLogger()
            // declare Android context
            androidContext(this@FibonacciNumbersApplication)
        }
    }
}