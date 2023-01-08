package com.example.noteapp_room.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp_room.R
import com.example.noteapp_room.databinding.FragmentDetailBinding
import com.example.noteapp_room.model.NoteModel


class DetailFragment : Fragment() {
lateinit var binding:FragmentDetailBinding
lateinit var carrentNote:NoteModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(layoutInflater)
        carrentNote = arguments?.getSerializable("note") as NoteModel
return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {



    }

}