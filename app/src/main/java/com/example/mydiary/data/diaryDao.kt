package com.example.mydiary.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.data.Diary

@Dao
interface DiaryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun adddiary(diary: Diary)

    @Update
    suspend fun update(diary: Diary)

    @Delete
    suspend fun delete(diary: Diary)

    @Query("Select * from diaryTable order by id DESC")
    fun readalldata(): LiveData<List<Diary>>
}
// TODO: adddiary to addDiary readAllData
// TODO: update delete