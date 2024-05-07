package com.example.btvn6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.btvn6.data.Note
import com.example.btvn6.data.NoteRoomDatabase
import com.example.btvn6.data.noteList
import com.example.btvn6.databinding.ActivitySecondBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.AddNote.setOnClickListener {
            val now = Date()
            val formatter = SimpleDateFormat("HH:mm dd-MM-yyyy")
            val formattedDateTime: String = formatter.format(now)
             val note = Note (
                 title = binding.editTextTitle.text.toString(),
                 createAt = formattedDateTime,
                 content = binding.editTextContent.text.toString()
             )
            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDAO().addNote(note)
            }
            CoroutineScope(Dispatchers.IO).launch {
                noteList.list = noteRoomDatabase.noteDAO().getAllNote()
                noteRoomDatabase.noteDAO().updateNote(noteList.list)
            }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}