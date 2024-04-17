package com.example.testandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class NoteActivity(var noteList: MutableList<dataNote> = mutableListOf()): RecyclerView.Adapter<NoteActivity.NoteViewHolder>() {
    class NoteViewHolder(item : View): RecyclerView.ViewHolder(item) {
        val titles =item.findViewById<TextView>(R.id.noteTitle)
        val creat = item.findViewById<TextView>(R.id.noteTime)
        val contents = item.findViewById<TextView>(R.id.noteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.titles.text = noteList[position].title
        holder.creat.text = noteList[position].createdAt.toString()
        holder.contents.text = noteList[position].content
    }
}