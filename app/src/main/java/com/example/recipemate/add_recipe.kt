package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class add_recipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_recipe)

        // Back button
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Goes back to previous page
        }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set up listener for bottom navigation item selection
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Navigate to HomeActivity
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_add_recipe -> {
                    // Navigate to AddRecipeActivity
                    true
                }

                R.id.nav_camera -> {
                    // Navigate to CameraActivity
                    val intent = Intent(this, Camera::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_favorites -> {
                    // Navigate to FavoritesActivity
                    val intent = Intent(this, Favourites::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_settings -> {
                    // Navigate to SettingsActivity
                    val intent = Intent(this, Settings::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }}

        // You can manually select the Home item when you first open the activity
        bottomNavigationView.selectedItemId = R.id.nav_add_recipe // Set default item as Home

        }
    }
