package com.nahum.androidcurso1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        //Al arrancar la pantalla se ejecuta primero


        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etText = findViewById<AppCompatEditText>(R.id.etName)

        btnStart.setOnClickListener{
            val name=etText.text.toString()
            if(name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME",name)
                startActivity(intent)
            }else{

            }

        }

    }
}