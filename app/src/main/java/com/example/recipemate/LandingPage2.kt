package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LandingPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing_page2)

        // Back button
        val backButton = findViewById<Button>(R.id.button3)
        backButton.setOnClickListener {
            finish() // Goes back to LandingPage1
        }

        // Next button
        val nextButton = findViewById<Button>(R.id.button2)
        nextButton.setOnClickListener {
            val intent = Intent(this, LandingPage3::class.java) // Go to next page
            startActivity(intent)
        }
    }
}
