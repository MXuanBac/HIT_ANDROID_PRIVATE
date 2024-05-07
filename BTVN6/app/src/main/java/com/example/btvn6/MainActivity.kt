package com.example.btvn6

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.btvn6.data.NoteRoomDatabase
import com.example.btvn6.data.noteList
import com.example.btvn6.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val noteDatabase by lazy { NoteRoomDatabase.getDatabase(this)}

    private val allNoteFragment = AllNoteFragment()
    private val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            noteList.list = noteDatabase.noteDAO().getAllNote()
            noteDatabase.noteDAO().updateNote(noteList.list)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view_tag, allNoteFragment)
                .setReorderingAllowed(true)
                .commit()
        }

        binding.allNote.setOnClickListener {
            binding.allNote.visibility = View.VISIBLE
            binding.favoriteNote.visibility = View.VISIBLE

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view_tag, allNoteFragment)
                .setReorderingAllowed(true)
                .commit()
        }

        binding.favoriteNote.setOnClickListener {
            binding.allNote.visibility = View.VISIBLE
            binding.favoriteNote.visibility = View.VISIBLE

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view_tag, favoriteFragment)
                .setReorderingAllowed(true)
                .commit()
        }

        binding.btnAdd.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                noteDatabase.noteDAO().updateNote(noteList.list)
            }
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }
    override fun onResume() {
        super.onResume()
        allNoteFragment.reset()
        favoriteFragment.reset()
    }
}