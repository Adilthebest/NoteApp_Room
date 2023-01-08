package com.example.noteapp_room.room.repository

import androidx.lifecycle.LiveData
import com.example.noteapp_room.model.NoteModel

interface NoteRepository {
    val allNotes:LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel,onSuccess:()-> Unit)
    suspend fun deleteNote(noteModel: NoteModel,onSuccess:()-> Unit)
}