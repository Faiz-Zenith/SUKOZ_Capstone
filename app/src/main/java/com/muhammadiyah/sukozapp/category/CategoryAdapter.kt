package com.muhammadiyah.sukozapp.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadiyah.sukozapp.databinding.ItemCategoryBinding
import com.muhammadiyah.sukozapp.model.Category

class CategoryAdapter(
    private val categories: List<Category>,
    private val onCategorySelected: (List<Category>) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val selectedCategories = mutableListOf<Category>()

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val category = categories[adapterPosition]
                if (selectedCategories.contains(category)) {
                    selectedCategories.remove(category)
                    binding.root.alpha = 1.0f
                } else {
                    selectedCategories.add(category)
                    binding.root.alpha = 0.5f
                }
                onCategorySelected(selectedCategories)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.tvCategoryName.text = category.name
        holder.binding.root.alpha =
            if (selectedCategories.contains(category)) 0.5f else 1.0f // Update tampilan
    }

    override fun getItemCount(): Int = categories.size
}
