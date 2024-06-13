package com.example.caknorris.apiservice

import android.telecom.Call
import com.example.caknorris.model.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object ApiService {
    private const val BASE_URL = "https://api.chucknorris.io/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val chuckNorrisApi: ChuckNorrisApi = retrofit.create(ChuckNorrisApi::class.java)
}

