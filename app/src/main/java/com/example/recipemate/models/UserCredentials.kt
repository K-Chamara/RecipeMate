package com.example.recipemate.models

// Singleton Object to hold the credentials temporarily
object UserCredentials {
    var username: String? = null
    var email: String? = null
    internal var password: String? = null

    // Set password with confirmation check
    fun setPassword(password: String, rePassword: String): Boolean {
        return if (password == rePassword) {
            this.password = password
            true
        } else {
            false
        }
    }

    // Validate if the entered password matches the stored password
    fun getPassword(pass: String): Boolean {
        return this.password == pass
    }
}
