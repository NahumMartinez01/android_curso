package com.nahum.androidcurso1.toDoApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nahum.androidcurso1.R

class CategoriesAdapter(private val categories:List<TaskCategory>, private val onItemSelected: (Int) -> Unit):
    RecyclerView.Adapter<CategoryViewFolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewFolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoryViewFolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoryViewFolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }


}