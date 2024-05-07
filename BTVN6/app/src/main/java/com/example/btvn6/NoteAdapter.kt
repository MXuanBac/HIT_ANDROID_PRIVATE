package com.example.btvn6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.btvn6.data.Note
import com.example.btvn6.data.NoteRoomDatabase
import com.example.btvn6.data.noteList
import com.example.btvn6.databinding.ActivityNoteBinding

class NoteAdapter (var dataNote: MutableList<Note> = mutableListOf()): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(val binding: ActivityNoteBinding): RecyclerView.ViewHolder(binding.root) {
        val nTitle = binding.noteTitle
        val nContent = binding.noteContent
        val nTime = binding.noteTime
        val nFavourite = binding.favorite
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder (
        binding = ActivityNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = dataNote.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(holder.itemView.context) }
        val list = noteRoomDatabase.noteDAO()

        holder.nTitle.text = dataNote[position].title
        holder.nTime.text = dataNote[position].createAt
        holder.nContent.text = dataNote[position].content
        if (dataNote[position].isFavorite) {
            holder.nFavourite.setImageResource(R.drawable.favorite_fill)
        }
        else {
            holder.nFavourite.setImageResource(R.drawable.favorite)
        }
        holder.binding.favorite.setOnClickListener {
            dataNote[position].isFavorite = !dataNote[position].isFavorite
            if (dataNote[position].isFavorite) {
                holder.binding.favorite.setImageResource(R.drawable.favorite_fill)
            } else {
                holder.binding.favorite.setImageResource(R.drawable.favorite)
            }
            noteList.list[position].isFavorite = dataNote[position].isFavorite
        }
    }
    fun setNotesList(notesList: MutableList<Note>) {
        this.dataNote = notesList
        notifyDataSetChanged()
    }
}