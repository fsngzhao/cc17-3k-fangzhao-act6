package com.example.a30days

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipeList: List<Recipt>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayTextView: TextView = itemView.findViewById(R.id.recipe_day)
        val titleTextView: TextView = itemView.findViewById(R.id.recipe_title)
        val imageView: ImageView = itemView.findViewById(R.id.recipe_image)
        val descriptionTextView: TextView = itemView.findViewById(R.id.recipe_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.dayTextView.text = recipe.day
        holder.titleTextView.text = recipe.title
        holder.imageView.setImageResource(recipe.imageRes)
        holder.descriptionTextView.text = recipe.description
    }

    override fun getItemCount() = recipeList.size
}