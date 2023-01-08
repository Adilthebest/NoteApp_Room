package com.example.noteapp_room.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.noteapp_room.R
import com.example.noteapp_room.databinding.FragmentStartBinding
import com.example.noteapp_room.model.NoteModel
import com.example.noteapp_room.ui.APP
import com.example.noteapp_room.ui.NoteAdapter

class StartFragment() : Fragment(){
    lateinit var adapter: NoteAdapter
    lateinit var binding:FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDataBase()
adapter = NoteAdapter()
        binding.recycle.adapter = adapter
viewModel.getAllNotes().observe(viewLifecycleOwner){listNotes->
    adapter.setList(listNotes)
}
        binding.add.setOnClickListener {
findNavController().navigate(R.id.addnoteFragment)
        }

    }
    companion object{
        fun onClick(noteModel:NoteModel){
            val  bundle = Bundle()
bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.startFragment,bundle)

        }

    }

}