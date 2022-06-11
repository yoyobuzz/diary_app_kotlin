package com.example.mydiary.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mydiary.R
import com.example.mydiary.fragments.list.listFragmentDirections
import com.example.mydiary.viewmodel.DiaryViewModel


class viewFragment : Fragment() {
    private val args by navArgs<viewFragmentArgs>()

    private lateinit var mDiaryViewModel: DiaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        val emoji = args.currentItem.emoji

        view?.findViewById<TextView>(R.id.heading_edit)?.text = args.currentItem.title
        view?.findViewById<TextView>(R.id.body_edit)?.text = args.currentItem.body
        view?.findViewById<TextView>(R.id.day)?.text = args.currentItem.day
        view?.findViewById<TextView>(R.id.date)?.text = args.currentItem.date

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

        view.findViewById<ImageView>(R.id.deleteButton).setOnClickListener{
            val builder = AlertDialog.Builder(requireContext())
            mDiaryViewModel= ViewModelProvider(this).get(DiaryViewModel::class.java)
            builder.setPositiveButton("Yes"){
                _,_ ->
                findNavController().navigate(R.id.action_viewFragment_to_listFragment)
                mDiaryViewModel.deleteDiary(args.currentItem)
                Toast.makeText(requireContext(), "Entry Deleted!!", Toast.LENGTH_SHORT).show()

            }

            builder.setNegativeButton("No"){
                _,_ ->
                Toast.makeText(requireContext(), "Cancelled!", Toast.LENGTH_SHORT).show()
            }
            builder.setTitle("Are you sure?")
            builder.setMessage("This entry will be deleted!")
            builder.create().show()
        }

        view.findViewById<ImageView>(R.id.editEntry).setOnClickListener{
            findNavController().navigate(viewFragmentDirections.actionViewFragmentToUpdateFragment(args.currentItem))
        }

        return view
    }
}