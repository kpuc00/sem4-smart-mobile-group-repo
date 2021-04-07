package com.hills_studio

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
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
        setContentView(R.layout.activity_app)
        //setSupportActionBar(findViewById(R.id.toolbar))

        //binding = ActivityAppBinding.inflate(layoutInflater)
        //val view = binding.root
       // setContentView(view)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_collections, R.id.navigation_events, R.id.navigation_members
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.toolbar_account -> {
            val toast = Toast.makeText(applicationContext, "Hello Javatpoint", Toast.LENGTH_LONG)
            toast.show()
            true
        }

        R.id.toolbar_settings -> {
            val toast = Toast.makeText(applicationContext, "Hello Javatpoint1", Toast.LENGTH_LONG)
            toast.show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}