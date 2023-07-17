package com.nahum.androidcurso1.Pokedex

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nahum.androidcurso1.R
import com.squareup.picasso.Picasso

class PokemonViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val tvName: TextView = itemView.findViewById(R.id.tvNamePokemon)
    private val tvIdPokemon: TextView = itemView.findViewById(R.id.tvIdPokemon)
    private val ivPokemon: ImageView = itemView.findViewById(R.id.ivPokemon)

    fun bind(pokemon: Pokemon, imageUrl: String?, pokemonId: Int?){
        tvName.text = pokemon.name
        tvIdPokemon.text = "# ${pokemonId.toString()}"
        if (imageUrl != null) Picasso.get().load(imageUrl).into(ivPokemon)
    }
}