package com.nahum.androidcurso1.SuperHeroList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nahum.androidcurso1.R

class SuperHeroAdapter(var superHeroList: List<SuperHeroItemResponse> = emptyList(), private val onItemSelected:(String) -> Unit):
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(superHeroList: List<SuperHeroItemResponse>){
        this.superHeroList = superHeroList

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return  superHeroList.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList[position], onItemSelected)

    }
}