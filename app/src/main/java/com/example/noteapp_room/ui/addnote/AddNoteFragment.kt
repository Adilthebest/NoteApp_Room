package com.example.noteapp_room.ui.addnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.noteapp_room.R
import com.example.noteapp_room.databinding.FragmentNoteAddBinding
import com.example.noteapp_room.model.NoteModel

class AddNoteFragment : Fragment(){
    lateinit var binding: FragmentNoteAddBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.btnNext.setOnClickListener {
            val title  = binding.title.text.toString()
            val description  = binding.description.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            findNavController().navigate(R.id.startFragment)

        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.startFragment)
        }

    }

}