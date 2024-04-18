package com.example.quotesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    private val quoteText : TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor : TextView
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingActionButton = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.floatingActionButton)
        val tvOnNext = findViewById<TextView>(R.id.tvOnNext)
        val tvOnPrevious = findViewById<TextView>(R.id.tvOnPrevious)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        setQuote(mainViewModel.getQuote())

        floatingActionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
            startActivity(intent)
        }

        tvOnNext.setOnClickListener {
            setQuote(mainViewModel.nextQuote())
        }

        tvOnPrevious.setOnClickListener {
            setQuote(mainViewModel.previousQuote())
        }


    }
    private fun setQuote(quote: Quote){
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

}