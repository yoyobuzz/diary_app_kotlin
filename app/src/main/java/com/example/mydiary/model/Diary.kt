package com.example.myapplication.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "diaryTable")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val date:String,
    val day:String,
    val title:String,
    val body:String,
    val emoji:Int
) : Parcelable

// TODO: parcelize check 