package com.example.btvn6

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvn6.data.noteList
import com.example.btvn6.databinding.FragmentAllNoteBinding

class AllNoteFragment : Fragment() {
    private val binding by lazy { FragmentAllNoteBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allNote.adapter = NoteAdapter(noteList.list)
        binding.allNote.layoutManager = LinearLayoutManager(this.context)
        NoteAdapter().setNotesList(noteList.list)
    }

    fun reset() {
        NoteAdapter().setNotesList(noteList.list)
    }
}