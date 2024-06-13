package com.example.caknorris.model

data class JokeSearchResponse(
    val total: Int,
    val result: List<Joke>
)