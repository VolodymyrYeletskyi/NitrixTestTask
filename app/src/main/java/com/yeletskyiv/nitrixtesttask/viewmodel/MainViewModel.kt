package com.yeletskyiv.nitrixtesttask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeletskyiv.nitrixtesttask.model.Drink
import com.yeletskyiv.nitrixtesttask.repository.DrinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val drinkRepository: DrinkRepository) : ViewModel() {

    private val _randomDrinkLiveData by lazy { MutableLiveData<Drink>() }
    val randomDrinkLiveData: LiveData<Drink> = _randomDrinkLiveData

    fun getRandomDrink() = viewModelScope.launch(Dispatchers.IO) {
        _randomDrinkLiveData.postValue(drinkRepository.getRandomDrink())
    }
}