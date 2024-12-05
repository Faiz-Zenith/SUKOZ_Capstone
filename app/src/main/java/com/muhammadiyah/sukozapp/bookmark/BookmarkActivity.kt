package com.muhammadiyah.sukozapp.bookmark

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.adapter.BookmarkAdapter
import com.muhammadiyah.sukozapp.databinding.ActivityBookmarkBinding
import com.muhammadiyah.sukozapp.detail.DetailActivity
import com.muhammadiyah.sukozapp.home.HomeActivity
import com.muhammadiyah.sukozapp.model.Recipe

class BookmarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookmarkBinding

    private val bookmarkedRecipes = listOf(
        Recipe(1, "Spaghetti Bolognese", "Pasta", "", R.drawable.placeholder_image),
        Recipe(2, "Grilled Chicken", "Main Course", "", R.drawable.placeholder_image),
        Recipe(3, "Caesar Salad", "Salad", "", R.drawable.placeholder_image)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecyclerView()
        setupBottomNavigation()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }
    }

    private fun setupRecyclerView() {
        val adapter = BookmarkAdapter(bookmarkedRecipes) { recipe ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("RECIPE_NAME", recipe.name)
                putExtra("CATEGORY", recipe.category)
                putExtra("RECIPE_IMAGE", recipe.imageRes)
            }
            startActivity(intent)
        }
        binding.rvBookmarks.layoutManager = LinearLayoutManager(this)
        binding.rvBookmarks.adapter = adapter
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.menu_bookmark -> {
                    Toast.makeText(this, "Already in Bookmark page", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
