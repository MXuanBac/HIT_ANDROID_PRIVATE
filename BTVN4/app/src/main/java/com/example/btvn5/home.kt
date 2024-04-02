package com.example.btvn5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvn5.databinding.ActivityHomeBinding

class home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var name: String
    private lateinit var pass: String
    private val list = mutableListOf<dataUser>()
    private lateinit var userAdapter: usersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("username").toString()
        pass = intent.getStringExtra("pass").toString()

        userAdapter = usersAdapter(list)
        binding.recylerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recylerView.adapter = userAdapter
        addUserToList(name, pass)

        binding.logout.setOnClickListener{
            val intent = Intent(this, Login::class.java);
            startActivity(intent)
        }
    }

    private fun addUserToList(username: String, password: String) {
        val newUser = dataUser(username, password, R.drawable.user)
        list.add(newUser)
    }
}