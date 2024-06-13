package com.example.caknorris.apiservice

import com.example.caknorris.model.Joke
import com.example.caknorris.model.JokeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {
    @GET("jokes/random")
    fun getRandomJoke(): Call<Joke>

    @GET("jokes/search")
    fun searchJokes(@Query("query") query: String): Call<JokeSearchResponse>
}