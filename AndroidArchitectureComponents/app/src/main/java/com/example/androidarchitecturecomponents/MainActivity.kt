package com.example.androidarchitecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvFacts = findViewById<TextView>(R.id.tvFacts)
        val btnUpdate = findViewById<TextView>(R.id.btnUpdate)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.factsLiveData.observe(this, Observer {
            //code
            tvFacts.text = it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }



    }
}
