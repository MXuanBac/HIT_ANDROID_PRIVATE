package com.example.testandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroid.databinding.FragmentNoteBinding
import java.util.Date

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    private val listNote = mutableListOf<dataNote> (
        dataNote("Title1", "content 1", Date(2023,1,20), true ),
        dataNote("Title2", "content 2", Date(2023,3,10), true ),
        dataNote("Title3", "content 3", Date(2023,4,15), false ),
        dataNote("Title4", "content 4", Date(2023,7,23), true ),
        dataNote("Title5", "content 5", Date(2023,9,30), false )
    )

    private val noteActivity = NoteActivity(listNote)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = noteActivity
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
    }
}