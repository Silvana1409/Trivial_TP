/*
Auteur : Silvana Esquivel H.
Annéé : 2022-2023
*/

package com.example.android.navigation

import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        //Declaration-Ajout la fléche "<-" en haut de la page
        val navController = this.findNavController(R.id.myNavHostFragment)

        //inclure comme 3eme parametre la disposition du drawerLyout
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        appBarConfiguration=AppBarConfiguration(navController.graph,drawerLayout)

        //la vue du navigation
        NavigationUI.setupWithNavController(binding.navView,navController)
    }
    //Méthode quand on appui sur a flèche "<-" il revinenne en arrière s'il n'y pas cette méthode il fait rien
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        //return navController.navigateUp()
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
}
