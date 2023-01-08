package com.example.noteapp_room.ui.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapp_room.model.NoteModel
import com.example.noteapp_room.room.NoteDataBase
import com.example.noteapp_room.room.repository.NoteRealization
import com.example.noteapp_room.ui.REPOSITORY

class StartViewModel(application: Application):AndroidViewModel(application) {

    val context = application

    fun initDataBase() {
        val noteDao = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(noteDao)
    }

        fun getAllNotes():LiveData<List<NoteModel>>{
            return REPOSITORY.allNotes
        }
    }
