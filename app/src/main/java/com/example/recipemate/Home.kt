package com.example.recipemate

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.recipemate.fragments.BreakfastFragment
import com.example.recipemate.fragments.LunchFragment
import com.example.recipemate.fragments.DinnerFragment
import com.example.recipemate.fragments.TeaTimeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.FlowLayout

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // For edge-to-edge support
        setContentView(R.layout.activity_home)

        // Set default fragment (Breakfast) when the activity starts
        loadFragment(BreakfastFragment())

        // Notification icon click listener
        val notiButton = findViewById<ImageView>(R.id.ivNotification)
        notiButton.setOnClickListener {
            val intent = Intent(this, Notification::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Set up listener for bottom navigation item selection
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Just return true to prevent opening the Home activity again
                    true
                }

                R.id.nav_add_recipe -> {
                    // Navigate to AddRecipeActivity
                    val intent = Intent(this, add_recipe::class.java)
                    startActivity(intent)
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
        bottomNavigationView.selectedItemId = R.id.nav_home // Set default item as Home


        // Category selector - RadioGroup
        val radioGroupCategories = findViewById<RadioGroup>(R.id.radioGroupCategories)
        val rbBreakfast = findViewById<RadioButton>(R.id.rbBreakfast)

        // Set Breakfast as selected by default
        rbBreakfast.isChecked = true

        // Set up category selection listener
        radioGroupCategories.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbBreakfast -> loadFragment(BreakfastFragment())
                R.id.rbLunch -> loadFragment(LunchFragment())
                R.id.rbDinner -> loadFragment(DinnerFragment())
                R.id.rbTeaTime -> loadFragment(TeaTimeFragment())
            }
        }
    }

    // Function to load the fragments dynamically based on selected category
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // Replace content in FragmentContainerView
        transaction.addToBackStack(null) // Add fragment transaction to back stack (optional)
        transaction.commit() // Commit the transaction
    }


}
