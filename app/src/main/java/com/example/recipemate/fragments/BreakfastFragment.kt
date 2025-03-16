package com.example.recipemate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipemate.R
import com.example.recipemate.adapters.RecipeAdapter
import com.example.recipemate.models.Recipe

class BreakfastFragment : Fragment(R.layout.activity_breakfast_fragment) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample Data for the RecyclerView
        val recipeList = listOf(
            Recipe(
                R.drawable.strawberry_cream_filled_mini_puff_pastries_garnished_with_pistachios,
                "Mini Puff Pastries with Pistachio",
                "120 Kcal",
                "20 Min"
            ),
            Recipe(
                R.drawable.waffles_topped_with_sliced_fruits_hot_chocolate,
                "Waffles topped with slices fruits",
                "64 Kcal",
                "12 Min"
            ),
            Recipe(
                R.drawable.side_view_hand_holding_fork_rice_meal_with_chicken_sauce_black_plate_tomatoes_blue_background,
                "Rice with Butter Chicken",
                "310 Kcal",
                "25 Min"
            ),
            Recipe(
                R.drawable.khan_pilav_with_various_fruits_inside,
                "Khan pilav with fruits inside",
                "90 Kcal",
                "10 Min"
            ),
            Recipe(R.drawable.fried_meat_cream_sauce_boiled_rice,
                "Arabic chicken salad",
                "90 Kcal",
                "10 Min"
            ),
            Recipe(R.drawable.fresh_chicken_salad_with_vegetable_dressing_arabic_caucasian_bread_white_plate_dietary_menu_proper_nutrition,
                "chicken salad with vegetables ",
                "90 Kcal",
                "10 Min"
            )
        )

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.rvPopularRecipes)

        // Initialize the adapter with the recipe list
        recipeAdapter = RecipeAdapter(recipeList)

        // Set the LinearLayoutManager to scroll horizontally
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = recipeAdapter

    }
}
