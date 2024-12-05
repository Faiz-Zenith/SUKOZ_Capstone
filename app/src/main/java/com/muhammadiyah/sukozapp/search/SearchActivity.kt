package com.muhammadiyah.sukozapp.search

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.databinding.ActivitySearchBinding
import com.muhammadiyah.sukozapp.model.Recipe
import com.muhammadiyah.sukozapp.adapter.RecipeAdapter
import android.text.Editable
import android.text.TextWatcher
import com.muhammadiyah.sukozapp.ui.HomeActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var recipeAdapter: RecipeAdapter
    private var searchQuery: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipeAdapter = RecipeAdapter(emptyList<Recipe>()) { recipe ->
            Toast.makeText(this, "Clicked on: ${recipe.name}", Toast.LENGTH_SHORT).show()
        }
        binding.rvSearchResults.layoutManager = LinearLayoutManager(this)
        binding.rvSearchResults.adapter = recipeAdapter

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.ivSearchIcon.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.menu_bookmark -> {
                    Toast.makeText(this, "Bookmark", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                searchQuery = s.toString()
                if (searchQuery?.isNotEmpty() == true) {
                    binding.tvSearchResult.text = "Result for '$searchQuery'"
                    searchFood(searchQuery ?: "")
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun searchFood(query: String) {
        val results = listOf(
            Recipe(id = 1, name = "Nasi Goreng", category = "Indonesian", imageUrl = ""),
            Recipe(id = 2, name = "Sate Ayam", category = "Indonesian", imageUrl = ""),
            Recipe(id = 3, name = "Gado-Gado", category = "Vegetarian", imageUrl = "")
        )

        recipeAdapter.updateData(results)
    }
}
