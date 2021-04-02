package com.hills_studio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hills_studio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.btnLogin.setOnClickListener {
            if (b.etEmail.text.trim()
                    .isNotEmpty() && b.etPassword.text.trim().isNotEmpty()
            ) {
                Toast.makeText(this, "Login clicked", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }
        b.tvNotRegistered.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}