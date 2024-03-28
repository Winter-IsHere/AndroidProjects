package com.example.practicexml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var btnFirstActivity = findViewById<Button>(R.id.btnFirstActivity)
        btnFirstActivity.setOnClickListener {
                Intent(this, SecondActivity::class.java).also {
                    startActivity(it)
                }
        }
    }
}