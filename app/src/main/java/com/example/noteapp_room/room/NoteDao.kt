package com.example.noteapp_room.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp_room.model.NoteModel
import java.nio.charset.CodingErrorAction.IGNORE

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(noteModel: NoteModel)

    @Delete
    fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
     fun getAllNotes():LiveData<List<NoteModel>>
}