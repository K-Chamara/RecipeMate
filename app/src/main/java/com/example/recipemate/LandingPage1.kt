package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class LandingPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page1)

        // Find button by ID
        val nextButton = findViewById<Button>(R.id.button1)

        // Set click listener to navigate to LandingPage2
        nextButton.setOnClickListener {
            val intent = Intent(this, LandingPage2::class.java)
            startActivity(intent)
        }
    }
}
