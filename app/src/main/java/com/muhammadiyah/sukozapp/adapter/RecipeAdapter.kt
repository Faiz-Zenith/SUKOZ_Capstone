package com.muhammadiyah.sukozapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammadiyah.sukozapp.databinding.ItemRecipeBinding
import com.muhammadiyah.sukozapp.model.Recipe

class RecipeAdapter(
    private var recipes: List<Recipe>,
    private val onItemClicked: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.tvRecipeName.text = recipe.name
            binding.tvCategory.text = recipe.category

            Glide.with(binding.root.context)
                .load(recipe.imageUrl)
                .into(binding.ivRecipe)

            binding.root.setOnClickListener {
                onItemClicked(recipe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }
}
