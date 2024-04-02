package com.example.practicexml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var btnSecondActivity = findViewById<Button>(R.id.btnSecondActivity)
        var btnSecondToThirdActivity = findViewById<Button>(R.id.btnSecondToThird)

        btnSecondActivity.setOnClickListener {
            finish()
        }

        btnSecondToThirdActivity.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}