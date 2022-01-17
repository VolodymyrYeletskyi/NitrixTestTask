package com.yeletskyiv.nitrixtesttask.di

import com.yeletskyiv.nitrixtesttask.repository.DrinkRepository
import com.yeletskyiv.nitrixtesttask.retrofit.DrinkApi
import com.yeletskyiv.nitrixtesttask.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

val networkModule = module {
    single {
        (Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build())
            .create(DrinkApi::class.java)
    }
}

val repositoryModule = module {
    single { DrinkRepository(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}