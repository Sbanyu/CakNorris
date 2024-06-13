package com.example.caknorris.view

import JokeRepositoryImpl
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caknorris.apiservice.ApiService
import com.example.caknorris.databinding.ActivityMainBinding
import com.example.caknorris.viewmodel.JokeViewModel
import com.example.caknorris.viewmodel.JokeViewModelFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: JokeViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var jokeAdapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val apiService = ApiService
        val jokeRepository = JokeRepositoryImpl(apiService.chuckNorrisApi)
        val viewModelFactory = JokeViewModelFactory(jokeRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(JokeViewModel::class.java)

        viewModel.getRandomJoke()

        binding.btnCari.setOnClickListener {
            viewModel.searchJokes(binding.etSearchTool.text.toString())
        }

        jokeAdapter = JokeAdapter(mutableListOf())
        binding.recyclerView.adapter = jokeAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.jokeLiveData.observe(this, Observer { jokes ->
            jokeAdapter.jokes.clear()
            jokeAdapter.jokes.addAll(listOf(jokes))
            jokeAdapter.notifyDataSetChanged()
        })

        viewModel.jokeListLiveData.observe(this, Observer { jokes ->
            jokeAdapter.jokes.clear()
            jokeAdapter.jokes.addAll(jokes)
            jokeAdapter.notifyDataSetChanged()
        })
    }
}

