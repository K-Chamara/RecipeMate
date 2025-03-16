package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.recipemate.models.UserCredentials

class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        val cret = findViewById<TextView>(R.id.textView9)
        cret.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }

        // Back button
        val backButton = findViewById<ImageView>(R.id.imageView10)
        backButton.setOnClickListener {
            finish() // Goes back to previous page
        }

        // Get references for form fields and login button
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Retrieve credentials from Singleton object
            val storedEmail = UserCredentials.email
            val storedPassword = UserCredentials.password

            // Validate login credentials
            if (storedEmail == null || storedPassword == null) {
                Toast.makeText(this, "No account found. Please sign up first.", Toast.LENGTH_SHORT).show()
            } else if (email == storedEmail && UserCredentials.getPassword(password)) {
                // If credentials match, navigate to Home
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
