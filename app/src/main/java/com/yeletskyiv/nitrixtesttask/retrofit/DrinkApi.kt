package com.yeletskyiv.nitrixtesttask.retrofit

import com.yeletskyiv.nitrixtesttask.model.DrinkResponse
import retrofit2.http.GET

interface DrinkApi {

    @GET("random.php")
    suspend fun getRandomDrink(): DrinkResponse
}