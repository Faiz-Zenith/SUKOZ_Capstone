package com.muhammadiyah.sukozapp.otp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.muhammadiyah.sukozapp.MainActivity
import com.muhammadiyah.sukozapp.R

class OTPActivity : AppCompatActivity() {

    private lateinit var etOtp: EditText
    private lateinit var btnVerify: Button
    private lateinit var tvResend: TextView
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        etOtp = findViewById(R.id.et_otp)
        btnVerify = findViewById(R.id.btn_verify)
        tvResend = findViewById(R.id.tv_resend)

        email = intent.getStringExtra("email") ?: ""

        btnVerify.setOnClickListener {
            val otp = etOtp.text.toString()
            if (otp.isNotEmpty()) {
                verifyOTP(otp)
            } else {
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show()
            }
        }

        tvResend.setOnClickListener {
            resendOTP()
        }
    }

    private fun verifyOTP(otp: String) {
        Toast.makeText(this, "OTP Verified", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun resendOTP() {
        Toast.makeText(this, "OTP Sent Again to $email", Toast.LENGTH_SHORT).show()
    }
}
