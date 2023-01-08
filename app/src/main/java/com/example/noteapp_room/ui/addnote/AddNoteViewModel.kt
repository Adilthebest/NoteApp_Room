package com.example.noteapp_room.ui.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp_room.model.NoteModel
import com.example.noteapp_room.ui.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {
     fun insert(noteModel: NoteModel,onSuccess:()-> Unit)=
        viewModelScope.launch(Dispatchers.IO) {
                REPOSITORY.insertNote(noteModel){
                    onSuccess
                }
        }
}