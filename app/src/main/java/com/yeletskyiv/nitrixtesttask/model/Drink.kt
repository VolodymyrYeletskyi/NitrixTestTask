package com.yeletskyiv.nitrixtesttask.model

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("strDrink")
    val name: String,

    @SerializedName("strDrinkThumb")
    val imageUrl: String,

    @SerializedName("strInstructions")
    val receipt: String
)