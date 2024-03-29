package com.example.noteapp_room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp_room.model.NoteModel

@Database(entities =[NoteModel::class], version = 1 )
abstract class NoteDataBase:RoomDatabase() {

    abstract fun getNoteDao():NoteDao

    companion object{
        private var database:NoteDataBase ?= null

        @Synchronized
        fun getInstance(context: Context):NoteDataBase{
            return if (database ==null){
                database = Room.databaseBuilder(context,NoteDataBase::class.java,"db").build()
                database as NoteDataBase
            }else{
                database as NoteDataBase
            }
        }
    }

}