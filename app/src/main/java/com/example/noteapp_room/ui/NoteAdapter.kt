package com.example.noteapp_room.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp_room.databinding.ItemNoteBinding
import com.example.noteapp_room.model.NoteModel
import com.example.noteapp_room.ui.start.StartFragment
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter ():RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
var listNote = emptyList<NoteModel>()

   inner class NoteViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteModel) {
binding.title.text = note.title
binding.description.text = note.description
binding.data.text = Data()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }

    override fun getItemCount(): Int {
        return listNote.size

    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
holder.itemView.setOnClickListener {
    StartFragment.onClick( listNote[holder.adapterPosition]) }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
holder.itemView.setOnClickListener (null)
    }
    fun Data():String{
return SimpleDateFormat("hh:mm,dd MMMM yyyy", Locale.getDefault()).format(Date())
    }
    fun setList(list:List<NoteModel>){
listNote = list
    }

}
