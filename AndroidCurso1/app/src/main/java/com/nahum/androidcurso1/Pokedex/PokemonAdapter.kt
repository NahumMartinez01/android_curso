package com.nahum.androidcurso1.Pokedex

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nahum.androidcurso1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonAdapter(private val pokemonList: List<Pokemon> = emptyList()) :
    RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
       val pokemon = pokemonList[position]

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.pokeApiService.getPokemonDetails(pokemon.name)
                if (response.isSuccessful) {
                    val pokemonDetails = response.body()
                    val pokemonId = pokemonDetails?.id
                    Log.i("pok", "$pokemonDetails")
                    val imageUrl = pokemonDetails?.sprites?.frontDefaultImageUrl

                    withContext(Dispatchers.Main) {
                        holder.bind(pokemon, imageUrl, pokemonId)
                    }

                }
            } catch (e: Exception) {
               Log.e("error", "$e")
            }
        }
    }


}