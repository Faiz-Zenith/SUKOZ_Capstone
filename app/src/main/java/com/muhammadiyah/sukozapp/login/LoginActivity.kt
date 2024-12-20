package com.muhammadiyah.sukozapp.login

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammadiyah.sukozapp.MainActivity
import com.muhammadiyah.sukozapp.R
import com.muhammadiyah.sukozapp.databinding.ActivityLoginBinding
import com.muhammadiyah.sukozapp.home.HomeActivity
import com.muhammadiyah.sukozapp.register.SignupActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                navigateToHomePage()
            }
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.ivTogglePassword.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.ivTogglePassword.setImageResource(R.drawable.ic_eye)
        } else {
            binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.ivTogglePassword.setImageResource(R.drawable.ic_eye_off)
        }
        isPasswordVisible = !isPasswordVisible
        // Pindahkan cursor ke akhir teks
        binding.etPassword.setSelection(binding.etPassword.text.length)
    }

    private fun navigateToHomePage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
