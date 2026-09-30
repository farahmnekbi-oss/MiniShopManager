package com.example.minishopmanager

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewproduct)

        // Noms des produits (strings.xml)
        val produits = resources.getStringArray(R.array.produits)

        // Une image par produit, dans le même ordre que la liste
        val images = listOf(
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_recent_history,
            android.R.drawable.ic_menu_share,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_edit
        )

        // Adapter personnalisé : texte + logo
        val adapter = object : ArrayAdapter<String>(
            this, R.layout.item_produit, R.id.tvNomProduit, produits
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                view.findViewById<ImageView>(R.id.imgProduit)
                    .setImageResource(images[position])
                return view
            }
        }

        listView.adapter = adapter

        // Clic sur un produit : Toast
        listView.setOnItemClickListener { parent, _, position, _ ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "Produit sélectionné : $item", Toast.LENGTH_SHORT).show()
        }
    }
}