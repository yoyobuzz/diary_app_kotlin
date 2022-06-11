package com.example.mydiary.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydiary.R
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Diary

class listAdapter :
    RecyclerView.Adapter<listAdapter.ViewHolder>() {

    private var diaryList= emptyList<Diary>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_list_adapter,
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = diaryList[position]

        holder.day.findViewById<TextView>(R.id.day_entry).text=currentItem.day
        holder.date.findViewById<TextView>(R.id.date_entry).text=currentItem.date
        holder.title.findViewById<TextView>(R.id.head_entry).text=currentItem.title
        when (currentItem.emoji) {
            1 -> {
                holder.emoji.findViewById<ImageView>(R.id.emoji_entry).setImageResource(R.drawable.ic_happy)
            }
            2 -> {
                holder.emoji.findViewById<ImageView>(R.id.emoji_entry).setImageResource(R.drawable.ic_blush)
            }
            3 -> {
                holder.emoji.findViewById<ImageView>(R.id.emoji_entry).setImageResource(R.drawable.ic_angry)
            }
            4 -> {
                holder.emoji.findViewById<ImageView>(R.id.emoji_entry).setImageResource(R.drawable.ic_sad)
            }
            5 -> {
                holder.emoji.findViewById<ImageView>(R.id.emoji_entry).setImageResource(R.drawable.ic_ded)
            }
        }
//        To View , Delete and Update

        holder.itemView.findViewById<CardView>(R.id.viewCardEntry).setOnClickListener{
            holder.itemView.findNavController().navigate(listFragmentDirections.actionListFragmentToViewFragment(currentItem))
        }

    }



    fun setData(diary:List<Diary>){
        this.diaryList=diary
        notifyDataSetChanged()
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount() = diaryList.size
    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val date: TextView = view.findViewById(R.id.date_entry)
        val day: TextView = view.findViewById(R.id.day_entry)
        val emoji: ImageView = view.findViewById(R.id.emoji_entry)
        val title: TextView =view.findViewById(R.id.head_entry)
    }
}