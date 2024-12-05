package com.muhammadiyah.sukozapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.muhammadiyah.sukozapp.databinding.ActivityMainBinding
import com.muhammadiyah.sukozapp.model.Category
import com.muhammadiyah.sukozapp.ui.HomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val categories = listOf(
        Category("1", "Vegan"),
        Category("2", "Vegetarian"),
        Category("3", "Nut"),
        Category("4", "Dairy"),
        Category("5", "Non Dairy"),
        Category("6", "Low Cal"),
        Category("7", "Low Cholesterol"),
        Category("8", "Low/No Sugar"),
        Category("9", "Pescatarian"),
        Category("10", "Summer"),
        Category("11", "Fall"),
        Category("12", "Dessert"),
        Category("13", "22-Minute Cooking"),
        Category("14", "Healthy"),
        Category("15", "Easy Recipe"),
        Category("16", "No Tree Nut"),
        Category("17", "High Protein")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categories.forEach { category ->
            val chip = Chip(this).apply {
                text = category.name
                isCheckable = true
                setChipBackgroundColorResource(R.color.default_chip_color)
                setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        setChipBackgroundColorResource(R.color.brown)
                    } else {
                        setChipBackgroundColorResource(R.color.default_chip_color)
                    }
                }
            }
            binding.chipGroupCategories.addView(chip)
        }

        binding.chipGroupCategories.setOnCheckedStateChangeListener { group, _ ->
            val isEnabled = group.checkedChipIds.isNotEmpty()
            binding.btnTakeMeToHome.isEnabled = isEnabled
            if (isEnabled) {
                binding.btnTakeMeToHome.setBackgroundColor(
                    ContextCompat.getColor(this, R.color.brown)
                )
            } else {
                binding.btnTakeMeToHome.setBackgroundColor(
                    ContextCompat.getColor(this, android.R.color.darker_gray)
                )
            }
        }

        binding.btnTakeMeToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
