package com.example.caknorris.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.caknorris.repository.JokeRepository

class JokeViewModelFactory(private val jokeRepository: JokeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JokeViewModel(jokeRepository) as T
    }
}