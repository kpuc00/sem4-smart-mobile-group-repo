package com.hills_studio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hills_studio.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var b: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        b = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.btnLogin.setOnClickListener {
            if (b.etEmail.text.trim()
                    .isNotEmpty() && b.etPassword.text.trim().isNotEmpty()
            ) {
                val intent = Intent(this, AppActivity::class.java)
                startActivity(intent)
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