package com.nahum.androidcurso1.imcApp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.nahum.androidcurso1.R
import com.nahum.androidcurso1.imcApp.ImcActivity.Companion.KEY

class ResultImcActivity : AppCompatActivity() {
    private  lateinit var tvResult:TextView
    private  lateinit var tvImc:TextView
    private  lateinit var tvDescription:TextView
    private  lateinit var  btnReCalculate: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        var result:Double = intent.extras?.getDouble(KEY) ?: -1.0

        initComponent()
        initUI(result)
        initListener()
    }



    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when(result) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.bajo_peso))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal))
                tvDescription.text =getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_sobre_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobre_peso))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obecidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obeso))
                tvDescription.text = getString(R.string.description_obecidad)
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvImc.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }


    private fun initComponent(){
        tvResult = findViewById(R.id.tvResult)
        tvImc = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)

    }



    private fun initListener() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }
}