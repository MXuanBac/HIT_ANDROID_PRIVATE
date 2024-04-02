package com.example.btvn5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.btvn5.databinding.ActivityLoginBinding

class Login: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val list = mutableListOf<dataUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val intent = Intent(this, Home::class.java)
        binding.login.setOnClickListener{
            val username = binding.username.text.toString()
            val pass = binding.password.text.toString()
            navigateToHome(username, pass)
        }

        binding.signUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
    private fun navigateToHome(username: String, password: String) {
        val intent = Intent(this, home::class.java)
        intent.putExtra("username", username)
        intent.putExtra("pass", password)
        startActivity(intent)
    }
}