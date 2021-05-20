package com.github.rexfilius.cocktailzuri.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.rexfilius.cocktailzuri.api.Drink
import com.github.rexfilius.cocktailzuri.api.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName

    private val _drinksLiveData = MutableLiveData<List<Drink>>()
    val drinksLiveData: LiveData<List<Drink>>
        get() = _drinksLiveData

    init {
        getDrinks()
    }

    private fun getDrinks() {
        viewModelScope.launch {
            try {
                _drinksLiveData.value = repository.getDrinks("Alcoholic").drinks
                Log.d(TAG, "${_drinksLiveData.value}")
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }
    }

}