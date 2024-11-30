package com.example.yourapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeName = intent.getStringExtra("RECIPE_NAME") ?: "Unknown Recipe"
        val category = intent.getStringExtra("CATEGORY") ?: "Unknown Category"
        val recipeImage = intent.getIntExtra("RECIPE_IMAGE", R.drawable.placeholder_image)
        val calories = intent.getStringExtra("CALORIES") ?: "0 Cal"
        val protein = intent.getStringExtra("PROTEIN") ?: "0g Pro"
        val sodium = intent.getStringExtra("SODIUM") ?: "0mg Sod"
        val ingredients = intent.getStringExtra("INGREDIENTS") ?: "No ingredients available."
        val instructions = intent.getStringExtra("INSTRUCTIONS") ?: "No instructions available."

        binding.tvRecipeName.text = recipeName
        binding.tvCategory.text = category
        binding.ivRecipeImage.setImageResource(recipeImage)
        binding.tvCalories.text = calories
        binding.tvProtein.text = protein
        binding.tvSodium.text = sodium
        binding.tvIngredientsList.text = ingredients
        binding.tvInstructionsDetails.text = instructions

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.ivBookmark.setOnClickListener {
            Toast.makeText(this, "$recipeName bookmarked!", Toast.LENGTH_SHORT).show()
            // TODO: Implement logic to save the recipe to bookmarks
        }

        binding.btnLetsCook.setOnClickListener {
            // TODO: Navigate to the cooking preparation page
            Toast.makeText(this, "Navigating to cooking preparation...", Toast.LENGTH_SHORT).show()
        }
    }
}
