package com.example.mydiary.fragments.list

import com.example.mydiary.R
import com.example.mydiary.viewmodel.DiaryViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listFragment : Fragment() {
    // TODO: renamed the class might cause problems 
    private lateinit var mDiaryViewModel: DiaryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_list, container, false)

//        RecyclerView.Recycler View initialisations
        val adapter= listAdapter()
        val recyclerview=view.findViewById<RecyclerView>(R.id.recycler_view_items)
        recyclerview.adapter=adapter
        recyclerview.layoutManager=LinearLayoutManager(requireContext())

        // View Model
        mDiaryViewModel=ViewModelProvider(this).get(DiaryViewModel::class.java)
        mDiaryViewModel.readAllData.observe(viewLifecycleOwner, Observer { diary->adapter.setData(diary) })



        view.findViewById<ImageView>(R.id.addNewEntry).setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addEntry)
        }
        return view
    }
}