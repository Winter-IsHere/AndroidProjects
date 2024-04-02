package com.example.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException


class MainActivity : AppCompatActivity() {
    private var tvInput : TextView? = null
    private var lastNumeric = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view : View){
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }
    fun onClear() {
        tvInput?.text = ""
    }

    fun onDecimalPoint() {
        if ( lastNumeric && !lastDot){
            tvInput?.append(".")
            lastDot = true
            lastNumeric = false
        }
    }

    fun onOperator(view: View){
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }
    private fun isOperatorAdded(value : String): Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
         }
    }
    @SuppressLint("SetTextI18n")
    fun onEqual()
    {
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()
            var prefix = ""

            try {
                if (tvValue.startsWith("-")){
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")){
                    val splitValue = tvValue.split("-")

                    var valueOne = splitValue[0]
                    val valueTwo = splitValue[1]

                    if (prefix.isNotEmpty()){
                        valueOne = prefix + valueOne
                    }

                    tvInput?.text = (valueOne.toDouble() - valueTwo.toDouble()).toString()
                }
                else if(tvValue.contains("+")){
                    val splitValue = tvValue.split("+")

                    var valueOne = splitValue[0]
                    val valueTwo = splitValue[1]

                    if (prefix.isNotEmpty()){
                        valueOne = prefix + valueOne
                    }

                    tvInput?.text = (valueOne.toDouble() + valueTwo.toDouble()).toString()
                }
                else if(tvValue.contains("/")){
                    val splitValue = tvValue.split("/")

                    var valueOne = splitValue[0]
                    val valueTwo = splitValue[1]

                    if (prefix.isNotEmpty()){
                        valueOne = prefix + valueOne
                    }

                    tvInput?.text = (valueOne.toDouble() / valueTwo.toDouble()).toString()
                }
                else{
                    val splitValue = tvValue.split("*")

                    var valueOne = splitValue[0]
                    val valueTwo = splitValue[1]

                    if (prefix.isNotEmpty()){
                        valueOne = prefix + valueOne
                    }

                    tvInput?.text = (valueOne.toDouble() * valueTwo.toDouble()).toString()
                }

            }catch (e : ArithmeticException){
                e.printStackTrace()
            }
        }
    }

}