package com.example.retrifitmvvmapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrifitmvvmapp.api.QuoteService
import com.example.retrifitmvvmapp.api.RetrofitHelper
import com.example.retrifitmvvmapp.repository.QuoteRepository
import com.example.retrifitmvvmapp.viewmodels.MainViewModel
import com.example.retrifitmvvmapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this, Observer {
            Log.d("WINTER",it.results.toString())
        })
    }
}