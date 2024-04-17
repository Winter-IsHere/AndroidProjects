package com.example.androidarchitecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var tvCounter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ViewModel
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Initialize Views
        val btnCounter = findViewById<Button>(R.id.btnCounter)
        tvCounter = findViewById(R.id.tvCounter)

        // Set initial text
        setText()

        // Increment button click listener
        btnCounter.setOnClickListener {
            mainViewModel.increment()
            setText()
        }

        Log.d("MAIN", "Activity onCreate")
    }

    override fun onResume() {
        super.onResume()
        // Update UI on resume
        setText()
    }

    private fun setText() {
        tvCounter.text = mainViewModel.count.toString()
    }
}
