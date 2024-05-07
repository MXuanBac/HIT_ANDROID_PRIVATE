package com.example.btvn6.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTETable")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "create")
    val createAt: String,
    @ColumnInfo(name = "favorite")
    var isFavorite: Boolean = false
)
object noteList{
    var list = mutableListOf<Note>()
}
