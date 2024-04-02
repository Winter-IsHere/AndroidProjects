package com.example.ageinminutescalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var tvDate : TextView? = null
    private var tvMinutes : TextView? = null
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDate = findViewById(R.id.tvDate)
        tvMinutes = findViewById(R.id.tvMinutes)
        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker(){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->
//            Toast.makeText(this,"Date Picker Works", Toast.LENGTH_LONG).show()
            val selectedDate = "${selectedDayOfMonth}/${selectedMonth+1}/${selectedYear}"
            tvDate?.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            theDate?.let {
                val selectedDateInMinutes = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                    val currentDateInMinutes = currentDate.time / 60000
                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                    tvMinutes?.text = differenceInMinutes.toString()
                }
                }
        },year,month,day)


        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}