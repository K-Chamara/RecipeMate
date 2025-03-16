package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingPage3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing_page3)

        // Back button
        val backButton = findViewById<Button>(R.id.button5)
        backButton.setOnClickListener {
            finish() // Goes back to LandingPage1
        }

        // Next button
        val nextButton = findViewById<Button>(R.id.button4)
        nextButton.setOnClickListener {
            val intent = Intent(this, Welcome::class.java) // Go to next page
            startActivity(intent)
        }
    }
}