package com.example.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.programmingList)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"J","Java")
        val p2 = ProgrammingItem(2,"K","Kotlin")
        val p3 = ProgrammingItem(3,"C","C++")

        adapter.submitList(listOf(p1,p2,p3))

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)
        recycleView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p3 = ProgrammingItem(3,"C","C++")
            val p4 = ProgrammingItem(3,"P","Python")
            val p5 = ProgrammingItem(3,"R","Rust")
            val p6 = ProgrammingItem(3,"C","C#")

            adapter.submitList(listOf(p3,p4,p5,p6))
        }, 5000)
    }
}