package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find imageView3 and apply the scale animation
        val imageView3: ImageView = findViewById(R.id.imageView1)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.wiggle)

        // Set animation listener to move to the next page after animation ends
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Move to LandingPage1Activity after animation ends
                startActivity(Intent(this@MainActivity, LandingPage1::class.java))
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        imageView3.startAnimation(scaleAnimation)
    }
}
