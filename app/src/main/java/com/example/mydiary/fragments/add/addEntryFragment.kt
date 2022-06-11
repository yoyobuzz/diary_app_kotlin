package com.example.mydiary.fragments.add


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.data.Diary
import com.example.mydiary.R
import com.example.mydiary.viewmodel.DiaryViewModel
import java.util.*

class AddEntryFragment : Fragment() {

    private lateinit var mDiaryViewModel: DiaryViewModel
    var selectEmoji=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_add_entry, container, false)
        mDiaryViewModel=ViewModelProvider(this).get(DiaryViewModel::class.java)

        view.findViewById<ImageView>(R.id.happy).setOnClickListener{
            selectEmoji=1
            view.findViewById<ImageView>(R.id.happy).setImageResource(R.drawable.ic_happy)
            view.findViewById<ImageView>(R.id.blush).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.blush).setOnClickListener{
            selectEmoji=2
            view.findViewById<ImageView>(R.id.happy).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush).setImageResource(R.drawable.ic_blush)
            view.findViewById<ImageView>(R.id.angry).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.angry).setOnClickListener{
            selectEmoji=3
            view.findViewById<ImageView>(R.id.happy).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry).setImageResource(R.drawable.ic_angry)
            view.findViewById<ImageView>(R.id.sad).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.sad).setOnClickListener{
            selectEmoji=4
            view.findViewById<ImageView>(R.id.happy).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad).setImageResource(R.drawable.ic_sad)
            view.findViewById<ImageView>(R.id.ded).setImageResource(R.drawable.ic_ded_blurred)
        }
        view.findViewById<ImageView>(R.id.ded).setOnClickListener{
            selectEmoji=5
            view.findViewById<ImageView>(R.id.happy).setImageResource(R.drawable.ic_happy_blurred)
            view.findViewById<ImageView>(R.id.blush).setImageResource(R.drawable.ic_blush_blurred)
            view.findViewById<ImageView>(R.id.angry).setImageResource(R.drawable.ic_angry_blurred)
            view.findViewById<ImageView>(R.id.sad).setImageResource(R.drawable.ic_sad_blurred)
            view.findViewById<ImageView>(R.id.ded).setImageResource(R.drawable.ic_ded)
        }

        view.findViewById<TextView>(R.id.date).setText(getdate())
        view.findViewById<TextView>(R.id.day).setText(getday())


        view.findViewById<ImageView>(R.id.addNewEntry).setOnClickListener{
            insertDatatoDatabase()
        }

        return view
    }

    private fun insertDatatoDatabase() {
        val date_today=getdate()
        val day_today=getday()
        val diary_heading= view?.findViewById<EditText>(R.id.heading)?.text.toString()
        val diary_description= view?.findViewById<EditText>(R.id.body)?.text.toString()

        if(inputCheck(diary_heading)){
            Toast.makeText(requireContext(),"Give a Title!",Toast.LENGTH_SHORT).show()
        }
        else if(inputCheck(diary_description)){
            Toast.makeText(requireContext(),"Fill the Diary!",Toast.LENGTH_SHORT).show()
        }
        else if(selectEmoji==0){
            Toast.makeText(requireContext(),"Select an emoji!",Toast.LENGTH_SHORT).show()
        }
        else{
            //Create Diary Object and pass into it
            val diary= Diary(0,date_today,day_today,diary_heading,diary_description,selectEmoji)

            mDiaryViewModel.addDiary(diary)

            Toast.makeText(requireContext(),"Diary recorded!",Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addEntry_to_listFragment)
        }

    }

    private fun getdate(): String {
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()
        val month = (Calendar.getInstance().get(Calendar.MONTH))
        val monthh = arrayOf<String>("January","February","March","April","May","June","July","August","September","October","November","December",)
        val year = Calendar.getInstance().get(Calendar.YEAR).toString()
        return "$day ${monthh[month]} $year "
    }
    private fun getday(): String {
        val dayOfWeek: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        val weekday = arrayOf<String>("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        return weekday[dayOfWeek-1]

    }

    private fun inputCheck(string: String):Boolean{
        return (TextUtils.isEmpty(string))
    }
}