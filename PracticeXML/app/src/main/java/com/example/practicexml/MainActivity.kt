package com.example.practicexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkboxandradio)
        var radioMeatGroup = findViewById<RadioGroup>(R.id.radioMeatGroup)
        var cbOnion = findViewById<CheckBox>(R.id.cbOnion)
        var cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        var cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        var result = findViewById<TextView>(R.id.tvOrderResult)
        var btnOrder = findViewById<Button>(R.id.btnOrder)

        btnOrder.setOnClickListener{
            val checkedRadioMeatButtonId = radioMeatGroup.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedRadioMeatButtonId)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You ordered a burger with:\n${meat.text}" + (if (cheese) "\nCheese" else "") +
                    (if (onion) "\nOnion" else "") +
                    (if (salad) "\nSalad" else "")
            result.text = orderString
        }
    }
}