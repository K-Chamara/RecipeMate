package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)


        // Next button (Login Button)
        val nextButton = findViewById<Button>(R.id.button5)
        nextButton.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java) // Go to next page
            startActivity(intent)
        }

        val createAccountText = findViewById<TextView>(R.id.textView6)
        createAccountText.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }}
