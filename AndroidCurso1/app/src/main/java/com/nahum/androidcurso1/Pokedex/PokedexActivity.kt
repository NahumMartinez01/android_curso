package com.nahum.androidcurso1.Pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.nahum.androidcurso1.databinding.ActivityPokedexBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    private lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        getPokemonList()
//        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchByName(query.orEmpty())
//
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//
//        })

        binding.rvPokemones.setHasFixedSize(true)
        binding.rvPokemones.layoutManager = GridLayoutManager(this, 3)

    }

    private fun getPokemonList(){
        CoroutineScope(Dispatchers.IO).launch {

                val response = RetrofitClient.pokeApiService.getPokemon(22)
                if (response.isSuccessful) {
                    val pokemonListResponse = response.body()
                    val pokemonList = pokemonListResponse?.results?.map { pokemonResult ->
                        Pokemon(pokemonResult.name, "", 0)
                    }
                    runOnUiThread {
                        val adapter = pokemonList?.let {pokemon -> PokemonAdapter(pokemon) }
                        binding.rvPokemones.adapter = adapter
                    }
                }

        }

    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}