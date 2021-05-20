package com.github.rexfilius.cocktailzuri.fragments.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.rexfilius.cocktailzuri.api.DrinkDetail
import com.github.rexfilius.cocktailzuri.api.Repository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {

    private val TAG = DetailViewModel::class.java.simpleName

    private val _drinksDetailLiveData = MutableLiveData<List<DrinkDetail>>()
    val drinksDetailLiveData: LiveData<List<DrinkDetail>>
        get() = _drinksDetailLiveData

    fun getDrinksDetail(id: String) {
        try {
            viewModelScope.launch {
                _drinksDetailLiveData.value = repository.getDrinkDetails(id).drinks
            }
        } catch (e: Exception) {
            Log.d(TAG, e.message.toString())
        }
    }
}