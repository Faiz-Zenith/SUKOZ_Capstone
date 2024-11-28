package com.muhammadiyah.sukozapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammadiyah.sukozapp.databinding.ActivityMainBinding
import com.muhammadiyah.sukozapp.category.CategoryAdapter
import com.muhammadiyah.sukozapp.home.HomeActivity
import com.muhammadiyah.sukozapp.model.Category

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private val categories = listOf(
        Category("Masakan suda"),
        Category("Masakan Jawa"),
        Category("Masakan Tegal"),
        Category("Masakan Malang"),
        Category("Masakan Bandung")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryAdapter = CategoryAdapter(categories) { selectedCategories ->
            binding.btnTakeMeToHome.visibility = if (selectedCategories.isNotEmpty()) View.VISIBLE else View.GONE
        }

        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCategories.adapter = categoryAdapter

        binding.btnTakeMeToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
