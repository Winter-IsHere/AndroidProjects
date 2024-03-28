package com.example.multipleactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tvSecondActivity = findViewById<TextView>(R.id.tvSecondActivity)
        var person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvSecondActivity.text = person.toString()

    }
}