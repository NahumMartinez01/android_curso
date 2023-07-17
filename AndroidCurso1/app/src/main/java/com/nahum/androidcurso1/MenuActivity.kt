package com.nahum.androidcurso1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nahum.androidcurso1.Pokedex.PokedexActivity
import com.nahum.androidcurso1.SuperHeroList.SuperHeroListActivity
import com.nahum.androidcurso1.ajustesApps.AjustesActivity
import com.nahum.androidcurso1.imcApp.ImcActivity
import com.nahum.androidcurso1.toDoApp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImc = findViewById<Button>(R.id.btnImcApp)
        val btnTodoApp = findViewById<Button>(R.id.btnTodoApp)
        val btnSuperHeroApp = findViewById<Button>(R.id.btnSuperHeroApp)
        val btnPokedex = findViewById<Button>(R.id.btnPokedex)
        val btnSetting = findViewById<Button>(R.id.btnSetting)

        btnSaludApp.setOnClickListener {
            navigateToSaludApp()
        }

        btnImc.setOnClickListener{
            navigateToImcApp()
        }

        btnTodoApp.setOnClickListener{
            navigateToTodoApp()
        }

        btnSuperHeroApp.setOnClickListener {
            navigateToSuperHeroApp()
        }

        btnPokedex.setOnClickListener {
            navigateToPokedex()
        }

        btnSetting.setOnClickListener {
            navigateToSetting()
        }
    }

    private fun navigateToSetting() {
        val intent = Intent(this, AjustesActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToPokedex() {
        val intent = Intent(this, PokedexActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java )
        startActivity(intent)
    }

    private fun navigateToImcApp(){
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }


    private fun navigateToTodoApp(){
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }
}