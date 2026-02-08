package com.example.kmpproject1

import android.app.Application
import com.example.kmpproject1.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@MyApp)
        }
    }
}