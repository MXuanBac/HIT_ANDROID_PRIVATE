package com.example.btvn6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvn6.data.Note
import com.example.btvn6.data.noteList
import com.example.btvn6.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private val binding by lazy { FragmentFavoriteBinding.inflate(layoutInflater) }
    private var noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.favoriteNote.layoutManager = LinearLayoutManager(requireContext())
        binding.favoriteNote.adapter = noteAdapter

        noteAdapter.setNotesList(noteList.list.filter {
            it.isFavorite
        } as MutableList<Note>)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    fun reset() {
        NoteAdapter().setNotesList(noteList.list)
    }
}