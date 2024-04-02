package com.example.btvn5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.btvn5.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val color = ContextCompat.getColor(this, R.color.red)
        val intent1 = Intent(this, home::class.java)

        binding.signUp.setOnClickListener{
            if (checkPassword() == false){
                binding.checkPassword.setText("Passwords are not duplicates")
            }
            else{
                binding.checkPassword.setText("Duplicate password")
                if (checkPasswordCorrect()){
                    val username = binding.username.text.toString()
                    val pass = binding.password.text.toString()
                    intent1.putExtra("username", username)
                    intent1.putExtra("pass", pass)
                    startActivity(intent1)
                }
            }
        }

        binding.login.setOnClickListener{
            intent = Intent(this, Login ::class.java)
            startActivity(intent)
        }
    }

    private fun checkPassword() : Boolean{
        try{
            if(binding.password.text.toString().equals(binding.passwordRequest.text.toString())){
                return true
            }
            return false
        }
        catch (e:Exception){
            return false
        }
    }
    private fun checkPasswordCorrect():Boolean{
        val pass = binding.password.text.toString()
        if(pass != null){
            if(pass.length < 8){
                return false
            }
            else{
                return true
            }
        }
        return false
    }
}