package com.muhammadiyah.sukozapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T>(
    private val items: List<T>,
    private val bind: (View, T) -> Unit
) : RecyclerView.Adapter<GenericAdapter.GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return GenericViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val item = items[position]
        bind(holder.itemView, item)
    }

    override fun getItemCount() = items.size

    class GenericViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
