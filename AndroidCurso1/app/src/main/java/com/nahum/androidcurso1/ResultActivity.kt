package com.nahum.androidcurso1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = findViewById<TextView>(R.id.result)

        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        result.text = "Hola $name"

    }
}