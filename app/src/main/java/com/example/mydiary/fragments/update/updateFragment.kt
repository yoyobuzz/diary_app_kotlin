package com.example.mydiary.fragments.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.Update
import com.example.myapplication.data.Diary
import com.example.mydiary.R
import com.example.mydiary.viewmodel.DiaryViewModel
import com.google.android.material.textview.MaterialTextView
import java.util.logging.Logger.global

class updateFragment : Fragment() {
    private val args by navArgs<viewFragmentArgs>()

    private lateinit var mDiaryViewModel: DiaryViewModel
    private var updateEmoji = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        val emoji = args.currentItem.emoji
        updateEmoji = args.currentItem.emoji

        view?.findViewById<EditText>(R.id.heading_edit)?.setText(args.currentItem.title)
        view?.findViewById<EditText>(R.id.body_edit)?.setText(args.currentItem.body)
        view?.findViewById<EditText>(R.id.day)?.setText(args.currentItem.day)
        view?.findViewById<EditText>(R.id.date)?.setText(args.currentItem.date)

        when(emoji) {
            1 -> {
                view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy)
                view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
                view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
                view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
                view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
            }
            2 -> {
                view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
                view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush)
                view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
                view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
                view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
            }
            3 -> {
                view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
                view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
                view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry)
                view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
                view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
            }
            4 -> {
                view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
                view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
                view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
                view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad)
                view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
            }
            5 -> {
                view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
                view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
                view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
                view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
                view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded)
            }
        }

        view.findViewById<ImageView>(R.id.happy_edit).setOnClickListener{
            updateEmoji=1
            view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy)
            view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.blush_edit).setOnClickListener{
            updateEmoji=2
            view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush)
            view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.angry_edit).setOnClickListener{
            updateEmoji=3
            view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry)
            view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.sad_edit).setOnClickListener{
            updateEmoji=4
            view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad)
            view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.ded_edit).setOnClickListener{
            updateEmoji=5
            view.findViewById<ImageView>(R.id.happy_edit).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush_edit).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry_edit).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad_edit).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded_edit).setImageResource(R.drawable.ic_ded)
        }

        view.findViewById<ImageView>(R.id.saveChanges).setOnClickListener{
            updateEntry()
        }

        return view
    }

    private fun updateEntry(){
        mDiaryViewModel= ViewModelProvider(this).get(DiaryViewModel::class.java)
        val updateBody= view?.findViewById<EditText>(R.id.body_edit)?.text.toString()
        val updateTitle= view?.findViewById<EditText>(R.id.heading_edit)?.text.toString()
        val updateDay= view?.findViewById<EditText>(R.id.day)?.text.toString()
        val updateDate= view?.findViewById<EditText>(R.id.date)?.text.toString()

        if (inputCheck(updateDay)){
            Toast.makeText(requireContext(),"Day can't be empty!",Toast.LENGTH_SHORT).show()
        }
        else if (inputCheck(updateDate)){
            Toast.makeText(requireContext(),"Date can't be empty!",Toast.LENGTH_SHORT).show()
        }
        else if (inputCheck(updateTitle)){
            Toast.makeText(requireContext(),"Title can't be empty!",Toast.LENGTH_SHORT).show()
        }
        else if (inputCheck(updateBody)){
            Toast.makeText(requireContext(),"Diary can't be empty!",Toast.LENGTH_SHORT).show()
        }

        else{
            val updatedDiary= Diary(args.currentItem.id,updateDate,updateDay,updateTitle,updateBody,updateEmoji)
            mDiaryViewModel.updateDiary(updatedDiary)
            //Navigation to back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(),"Diary Updated!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(string: String):Boolean{
        return (TextUtils.isEmpty(string))
    }
}