package com.example.minishopmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Récupération du bouton depuis la vue
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Action au clic sur le bouton
        btnNext.setOnClickListener {
            // Affichage du Toast
            Toast.makeText(this, "Bonjour farah mnekbi !", Toast.LENGTH_SHORT).show()

            // Intent explicite pour ouvrir ProfileActivity
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Log pour le cycle de vie
        Log.d("LIFECYCLE", "onCreate appelé")
    }
}