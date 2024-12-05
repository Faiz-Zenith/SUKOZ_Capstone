package com.muhammadiyah.sukozapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.adapter.RecipeAdapter
import com.muhammadiyah.sukozapp.bookmark.BookmarkActivity
import com.muhammadiyah.sukozapp.databinding.ActivityHomeBinding
import com.muhammadiyah.sukozapp.detail.DetailActivity
import com.muhammadiyah.sukozapp.model.Recipe
import com.muhammadiyah.sukozapp.search.SearchActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupGreeting()
        setupSearchBar()
        setupWhatToCook()
        setupCookAgain()
        setupBottomNavigation()
    }

    private fun setupGreeting() {
        val userName = "User"
        binding.tvHelloUser.text = "Hello, $userName"
    }

    private fun setupSearchBar() {
        binding.btnSearch.setOnClickListener {
            val query = binding.etSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra("search_query", query)
                startActivity(intent)
            }
        }
    }

    private fun setupWhatToCook() {
        val recipes = listOf(
            Recipe(1, "Spaghetti Carbonara", "Main Dish", "https://via.placeholder.com/150"),
            Recipe(2, "Caesar Salad", "Appetizer", "https://via.placeholder.com/150"),
            Recipe(3, "Chocolate Cake", "Dessert", "https://via.placeholder.com/150")
        )

        val adapter = RecipeAdapter(recipes) { selectedRecipe ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("recipe_id", selectedRecipe.id)
            startActivity(intent)
        }

        binding.rvWhatToCook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvWhatToCook.adapter = adapter
    }

    private fun setupCookAgain() {
        val recipes = listOf(
            Recipe(4, "Beef Steak", "Main Dish", "https://via.placeholder.com/150"),
            Recipe(5, "Chicken Curry", "Main Dish", "https://via.placeholder.com/150"),
            Recipe(6, "Fruit Salad", "Dessert", "https://via.placeholder.com/150")
        )

        val adapter = RecipeAdapter(recipes) { selectedRecipe ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("recipe_id", selectedRecipe.id)
            startActivity(intent)
        }

        // Konfigurasi RecyclerView
        binding.rvCookAgain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCookAgain.adapter = adapter
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    true
                }
                R.id.menu_bookmark -> {
                    val intent = Intent(this, BookmarkActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
