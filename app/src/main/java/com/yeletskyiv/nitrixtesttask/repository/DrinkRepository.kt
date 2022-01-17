package com.yeletskyiv.nitrixtesttask.repository

import com.yeletskyiv.nitrixtesttask.model.Drink
import com.yeletskyiv.nitrixtesttask.retrofit.DrinkApi

class DrinkRepository(private val drinkApi: DrinkApi) {

    suspend fun getRandomDrink(): Drink {
        return drinkApi.getRandomDrink().drinks.first()
    }
}