package com.muhammadiyah.sukozapp.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.api.ApiClient
import com.muhammadiyah.sukozapp.category.CategoryAdapter
import com.muhammadiyah.sukozapp.databinding.ActivityHomeBinding
import com.muhammadiyah.sukozapp.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import com.muhammadiyah.sukozapp.search.SearchActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username") ?: "User"
        binding.tvHelloUser.text = "Hello, $username"

        binding.etSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        fetchCategories()

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.menu_bookmark -> {
                }
            }
            true
        }
    }

    private fun fetchCategories() {
        ApiClient.instance.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                if (response.isSuccessful) {
                    val categories = response.body() ?: emptyList()
                    setupCategories(categories)
                } else {
                    Toast.makeText(this@HomeActivity, "Failed to load categories", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupCategories(categories: List<Category>) {
        binding.rvWhatToCook.layoutManager = LinearLayoutManager(this)
        binding.rvWhatToCook.adapter = CategoryAdapter(categories)
    }
}
