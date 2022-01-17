package com.yeletskyiv.nitrixtesttask

import android.app.Application
import com.yeletskyiv.nitrixtesttask.di.networkModule
import com.yeletskyiv.nitrixtesttask.di.repositoryModule
import com.yeletskyiv.nitrixtesttask.di.viewModelModule
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(networkModule, repositoryModule, viewModelModule) }
    }
}