package com.example.caknorris.repository

import androidx.lifecycle.LiveData
import com.example.caknorris.apiservice.ApiService
import com.example.caknorris.model.Joke
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface JokeRepository {
    fun getRandomJoke(): LiveData<Joke>
    fun searchJokes(query: String): LiveData<List<Joke>>
}

