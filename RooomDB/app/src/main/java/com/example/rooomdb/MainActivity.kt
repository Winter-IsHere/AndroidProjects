package com.example.rooomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDisplayData = findViewById<TextView>(R.id.tvDisplayData)

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Jeffery","008", Date(),1))
        }

        tvDisplayData.setOnClickListener {
            database.contactDao().getContact().observe(this, Observer {
                tvDisplayData.text = it.toString()
            })
        }
    }
}