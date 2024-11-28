package com.muhammadiyah.sukozapp.category

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammadiyah.sukozapp.databinding.ItemCategoryBinding
import com.muhammadiyah.sukozapp.model.Category

class CategoryAdapter(private val categories: List<Category>, private val onCategorySelected: (List<Category>) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val selectedPositions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category, position)
    }

    override fun getItemCount() = categories.size

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, position: Int) {
            binding.btnCategory.text = category.name

            binding.btnCategory.setBackgroundColor(
                if (selectedPositions.contains(position)) {
                    Color.GRAY
                } else {
                    Color.DKGRAY
                }
            )

            // Menangani klik kategori
            binding.btnCategory.setOnClickListener {
                if (selectedPositions.contains(position)) {
                    selectedPositions.remove(position)
                } else {
                    selectedPositions.add(position)
                }
                notifyItemChanged(position)
                onCategorySelected(categories.filterIndexed { index, _ -> selectedPositions.contains(index) })
            }
        }
    }
}
