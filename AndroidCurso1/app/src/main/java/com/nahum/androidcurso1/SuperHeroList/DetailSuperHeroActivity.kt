package com.nahum.androidcurso1.SuperHeroList

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nahum.androidcurso1.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSuperHeroBinding
    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(id)
    }

    private fun getSuperHeroInformation(id: String){
        CoroutineScope(Dispatchers.IO).launch{
           val superHeroDetail =  getRetrofit().create(ApiService::class.java).getDetailsSuperHeroes(id)



            if(superHeroDetail.body()!= null){
                runOnUiThread{
                    createUI(superHeroDetail.body()!!)

                }
            }
        }
    }

    private fun createUI(superHero: SuperHeroDetailResponse) {
        Picasso.get().load(superHero.image.url).into(binding.ivSuperHeroImage)
        binding.tvSuperHeroName.text = superHero.name

        prepareStats(superHero.powerStats)
    }

    private fun prepareStats(powerStats: SuperHeroStats) {
        updateHeight(binding.vCombat, powerStats.combat)
        updateHeight(binding.vIntelligence, powerStats.durability)
        updateHeight(binding.vStrength, powerStats.strength)
        updateHeight(binding.vSpeed, powerStats.speed)
        updateHeight(binding.vPower, powerStats.power)
        updateHeight(binding.vDurability, powerStats.durability)

    }

    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height =  pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).toInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
}