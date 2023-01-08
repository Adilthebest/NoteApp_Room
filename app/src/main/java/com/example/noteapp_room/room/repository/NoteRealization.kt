package com.example.noteapp_room.room.repository

import androidx.lifecycle.LiveData
import com.example.noteapp_room.model.NoteModel
import com.example.noteapp_room.room.NoteDao

class NoteRealization(private val noteDao: NoteDao) :NoteRepository{
    override val allNotes: LiveData<List<NoteModel>>
    get() = noteDao.getAllNotes()
    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess
    }

}