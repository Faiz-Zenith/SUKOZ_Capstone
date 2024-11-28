package com.muhammadiyah.sukozapp.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammadiyah.sukozapp.databinding.ActivitySignupBinding
import com.muhammadiyah.sukozapp.login.LoginActivity
import com.muhammadiyah.sukozapp.otp.OTPActivity

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val username = binding.etUsername.text.toString()
            val age = binding.etAge.text.toString()
            val birthday = binding.etBirthday.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isEmpty() || username.isEmpty() || age.isEmpty() || birthday.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registrasi berhasil, silakan verifikasi OTP", Toast.LENGTH_SHORT).show()

                navigateToOTPPage(email)
            }
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun navigateToOTPPage(email: String) {
        val intent = Intent(this, OTPActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
        finish()
    }
}
