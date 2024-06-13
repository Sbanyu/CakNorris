package com.example.caknorris.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caknorris.model.Joke
import com.example.caknorris.repository.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel(private val jokeRepository: JokeRepository) : ViewModel() {
    private val _jokeLiveData = MutableLiveData<Joke>()
    val jokeLiveData: LiveData<Joke> = _jokeLiveData


    private val _jokeListLiveData = MutableLiveData<List<Joke>>()
    val jokeListLiveData: LiveData<List<Joke>> = _jokeListLiveData

    fun getRandomJoke() {
        jokeRepository.getRandomJoke().observeForever { joke ->
            _jokeLiveData.value = joke
        }
    }

    fun searchJokes(query: String) {
        jokeRepository.searchJokes(query).observeForever { jokes ->
            _jokeListLiveData.value = jokes
        }
    }
}