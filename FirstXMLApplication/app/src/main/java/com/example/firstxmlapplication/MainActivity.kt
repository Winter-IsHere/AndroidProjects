package com.example.firstxmlapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMultiply = findViewById<Button>(R.id.buttonMultiply)
        val btnSubtract = findViewById<Button>(R.id.buttonSub)
        val btnAdd = findViewById<Button>(R.id.buttonAdd)
        val btnDivide = findViewById<Button>(R.id.buttonDivide)
        val answer = findViewById<TextView>(R.id.textView)
        val num1  = findViewById<TextInputEditText>(R.id.textInputEditText)
        val num2 = findViewById<TextInputEditText>(R.id.textInputEditText2)

        btnMultiply.setOnClickListener{
            val input1 = num1.text.toString().toDouble()
            val input2 = num2.text.toString().toDouble()
            val result = input1 * input2
            answer.text = result.toString()
        }
        btnSubtract.setOnClickListener{
            val input1 = num1.text.toString().toDouble()
            val input2 = num2.text.toString().toDouble()
            val result = input1 - input2
            answer.text = result.toString()
        }
        btnAdd.setOnClickListener{
            val input1 = num1.text.toString().toDouble()
            val input2 = num2.text.toString().toDouble()
            val result = input1 + input2
            answer.text = result.toString()
        }
        btnDivide.setOnClickListener{
            val input1 = num1.text.toString().toDouble()
            val input2 = num2.text.toString().toDouble()
            if (input2 == 0.0){
                answer.text = "Cannot divide by 0"
            }
            else{
                val result = input1 / input2
                answer.text = result.toString()
            }

        }
    }
}