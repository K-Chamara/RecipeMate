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
import java.util.regex.Pattern

class SignUpPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_page)

        // Back button functionality
        val backButton = findViewById<ImageView>(R.id.imageView12)
        backButton.setOnClickListener {
            finish()  // Goes back to previous page
        }

        // Redirect to Login page if user already has an account
        val haveAcc = findViewById<TextView>(R.id.tvLogin)
        haveAcc.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java) // Navigate to login page
            startActivity(intent)
        }

        // Sign-up button functionality
        val signButton = findViewById<Button>(R.id.btnSignup)
        signButton.setOnClickListener {
            val etName = findViewById<EditText>(R.id.etName)
            val etEmail = findViewById<EditText>(R.id.etEmail)
            val etPassword = findViewById<EditText>(R.id.etPassword)
            val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Validate user inputs
            if (!isValidUsername(name)) {
                Toast.makeText(this, "Username should be 8-12 characters with a capital letter", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(email)) {
                Toast.makeText(this, "Invalid email. Make sure it's like example@domain.com", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if (!isValidPassword(password)) {
                Toast.makeText(this, "Password should be 8-16 characters, including a capital letter, number, and symbol", Toast.LENGTH_SHORT).show()
            } else {
                // Save user credentials in Singleton object
                UserCredentials.username = name
                UserCredentials.email = email
                if (UserCredentials.setPassword(password, confirmPassword)) {
                    Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                    // Redirect to Login page
                    val intent = Intent(this, LoginPage::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Error setting password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Username validation
    private fun isValidUsername(username: String): Boolean {
        return username.length in 8..12 && username.any { it.isUpperCase() }
    }

    // Email validation
    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.com$")
        return emailPattern.matcher(email).matches()
    }

    // Password validation
    private fun isValidPassword(password: String): Boolean {
        return password.length in 8..16 &&
                password.any { it.isUpperCase() } &&
                password.any { it.isDigit() } &&
                password.any { !it.isLetterOrDigit() }  // Includes a symbol
    }
}
