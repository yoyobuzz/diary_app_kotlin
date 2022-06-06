package com.example.mydiary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.Diary

@Database(entities=[Diary::class], version = 1, exportSchema = false)
abstract class DiaryDatabase : RoomDatabase() {
    abstract fun getDiaryDao(): DiaryDao

    companion object {
        @Volatile
        private var INSTANCE: DiaryDatabase?=null

        fun getDatabase(context: Context): DiaryDatabase {
            val tempinstance= INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    DiaryDatabase::class.java,
                    "diary_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }

    }
}
// TODO: change getDiaryDao to diaryDao