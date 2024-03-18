package com.example.carmediapopup

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the popup button
        val popupButton: Button = findViewById(R.id.popup_button)
        val diagnoisticPopup : Button = findViewById(R.id.popup_button2)

        // Set click listener for the popup button
        popupButton.setOnClickListener {
            showPopup(R.layout.popup_layout)
        }
        diagnoisticPopup.setOnClickListener{
            showPopup(R.layout.diagnostics_layout)
        }
    }

        private fun showPopup(layoutResourceId: Int) {
            // Inflate the popup layout
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(layoutResourceId, null)

            // Set width and height for the popup window
            val width = 1301
            val height = 620

            val popupWindow = PopupWindow(popupView, width, height, true)
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        }
}
