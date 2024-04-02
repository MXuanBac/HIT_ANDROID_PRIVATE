package com.example.btvn5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class usersAdapter(val userList: MutableList<dataUser>) :
    RecyclerView.Adapter<usersAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUsername = itemView.findViewById<TextView>(R.id.name)
        val textViewAddress = itemView.findViewById<TextView>(R.id.address)
        val img = itemView.findViewById<ImageView>(R.id.imageUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): usersAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemusers, parent, false)
        return UserViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: usersAdapter.UserViewHolder, position: Int) {
        holder.textViewUsername.text = userList[position].name
        holder.textViewAddress.text = userList[position].pass
        holder.img.setImageResource(userList[position].image)
        holder.img.setOnClickListener{
            userList.removeAt(position)
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int = userList.size
}