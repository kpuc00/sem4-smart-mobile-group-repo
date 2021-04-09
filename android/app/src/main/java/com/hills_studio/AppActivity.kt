package com.hills_studio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hills_studio.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.toolbar))

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_collections, R.id.navigation_events, R.id.navigation_members
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val accountBtn: ImageView = findViewById(R.id.toolbar_account)
        val settingsBtn: ImageView = findViewById(R.id.toolbar_settings)

        accountBtn.setOnClickListener{
            val id: Int  = R.id.toolbar_account
            openActivity(id)
        }
        settingsBtn.setOnClickListener{
            val id: Int  = R.id.toolbar_settings
            openActivity(id)
        }
    }

    private fun openActivity(id:Int) {
        intent
        when(id){
            R.id.toolbar_settings ->{
                intent = Intent(applicationContext, SettingsActivity::class.java)
            }
            R.id.toolbar_account ->{
                intent = Intent(applicationContext, ProfilePageActivity::class.java)
            }
        }
        startActivity(intent)
    }
}