package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var etName = findViewById<EditText>(R.id.etName)
        var etAge = findViewById<EditText>(R.id.etAge)
        var etCountry = findViewById<EditText>(R.id.etCountry)
        var btnApply = findViewById<Button>(R.id.btnApply)


        btnApply.setOnClickListener {
            var name = etName.text.toString()
            var age = etAge.text.toString().toInt()
            var country = etCountry.text.toString()
            var person = Person(name,age,country)

            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }
        }
    }
}