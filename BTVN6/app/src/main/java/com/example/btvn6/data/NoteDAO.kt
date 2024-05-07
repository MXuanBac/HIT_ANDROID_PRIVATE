package com.example.btvn6.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface NoteDAO {
    @Query("SELECT * FROM NOTETable")
    fun getAllNote(): MutableList<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note)

    @Update
    fun updateNote(note: MutableList<Note>)

    @Delete
    fun deleteNote(note: Note)
}