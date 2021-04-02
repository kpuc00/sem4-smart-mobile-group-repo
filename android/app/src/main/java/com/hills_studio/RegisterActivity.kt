package com.hills_studio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hills_studio.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var b: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        b = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnRegister.setOnClickListener {
            if (b.etFullName.text.trim()
                    .isNotEmpty() && b.etPhone.text.trim()
                    .isNotEmpty() && b.etEmail.text.trim()
                    .isNotEmpty() && b.etPassword.text.trim()
                    .isNotEmpty() && b.etConfirmPassword.text.trim().isNotEmpty()
            ) {
                Toast.makeText(this, "Successfully registered!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Input required", Toast.LENGTH_LONG).show()
            }
        }
    }
}