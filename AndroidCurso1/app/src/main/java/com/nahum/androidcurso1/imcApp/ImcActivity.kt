package com.nahum.androidcurso1.imcApp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.nahum.androidcurso1.R
import com.nahum.androidcurso1.result
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    companion object {
        const val KEY = "IMC_RESULT"
    }

    private  var isMaleSelector:Boolean = true
    private  var isFemaleSelector:Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 18
    private var currentHeight:Int = 120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var tvWeight:TextView
    private lateinit var tvAge:TextView
    private lateinit var rangeSliderHeight:RangeSlider
    private lateinit var btnSubstractWeight:FloatingActionButton
    private lateinit var btnAddWeight:FloatingActionButton
    private lateinit var btnSubstractAge:FloatingActionButton
    private lateinit var btnAddAge:FloatingActionButton
    private lateinit var btnCalculate:AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        initComponents()
        initListener()
        initUI()
    }



    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        tvAge= findViewById(R.id.tvAge)
        tvWeight = findViewById(R.id.tvWeight)
        rangeSliderHeight= findViewById(R.id.rangeSliderHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListener(){

        viewMale.setOnClickListener{
            changeGender()
            setGenderBackground()
        }

        viewFemale.setOnClickListener{
            changeGender()
            setGenderBackground()
        }

        rangeSliderHeight.addOnChangeListener { _, value, _ ->
            //para pasar formatear de decimal a entero

            val df = DecimalFormat("#.##")
             currentHeight = df.format(value).toInt()
            tvHeight.text = " ${currentHeight} cm"
        }

        btnAddWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }

        btnSubstractWeight.setOnClickListener {
            currentWeight  -= 1
            setWeight()
        }

        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

        btnSubstractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            calculateImc()
            navigateToResult(calculateImc())

        }
    }

    private fun navigateToResult(result: Double) {
       val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(KEY, result)

        startActivity(intent)
    }

    private fun calculateImc(): Double {
        val height = currentHeight.toDouble() / 100
        val df = DecimalFormat("#.##")
        var imc = currentWeight / (height * height)
        return  df.format(imc).toDouble()



    }



    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text  = "${currentWeight.toString()} Kg"
    }

    private fun changeGender(){
        isMaleSelector = !isMaleSelector
        isFemaleSelector = !isFemaleSelector
    }

    private fun setGenderBackground() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelector))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelector))
    }


    private fun getBackgroundColor(isSelectedComponent:Boolean): Int {
       val realColor =  if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, realColor)
    }

    private fun initUI() {
        setGenderBackground()
        setWeight()
    }



}