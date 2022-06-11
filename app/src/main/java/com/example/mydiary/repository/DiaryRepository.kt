package com.example.mydiary.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.Diary
import com.example.mydiary.data.DiaryDao

class DiaryRepository(private val diaryDao: DiaryDao) {
    val getAlldata: LiveData<List<Diary>> = diaryDao.readalldata()

    suspend fun addDiary(diary: Diary){
        diaryDao.adddiary(diary)
    }

    suspend fun delete(diary: Diary){
        diaryDao.delete(diary)
    }

    suspend fun update(diary: Diary){
        diaryDao.update(diary)
    }

}
// TODO: getAlldata to readAllData
// TODO: readalldata to readAllData and so on addDiary
// TODO: delete and update