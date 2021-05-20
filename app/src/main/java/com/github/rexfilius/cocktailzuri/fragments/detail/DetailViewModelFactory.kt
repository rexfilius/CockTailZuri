package com.github.rexfilius.cocktailzuri.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.rexfilius.cocktailzuri.api.Repository

class DetailViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}