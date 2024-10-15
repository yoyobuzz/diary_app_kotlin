
# Diary App  
![Kotlin](https://img.shields.io/badge/Kotlin-1DA1F2?style=for-the-badge&logo=kotlin&logoColor=white)  
A simple Diary app built with **Kotlin** that allows users to create, edit, and delete diary entries. Each entry can have an associated **emoji** to represent the mood or emotion. The app uses **Room Database** for local storage, with DAO interfaces to manage CRUD operations.

---

## Features  
- **Add New Entries**: Write daily entries with an associated emoji for mood tracking.  
- **Edit Entries**: Modify any previously saved entry.  
- **Delete Entries**: Easily remove entries you no longer need.  
- **Room Database**: Local storage of entries with efficient querying using DAO.  
- **Kotlin-based UI**: Smooth and interactive user experience.

---

## Technology Stack  
- **Kotlin**: Language used to build the app.  
- **Room Database**: For storing and managing diary entries locally.  
- **DAO (Data Access Object)**: Interfaces for managing CRUD operations on the database.  
- **MVVM Architecture**: Follows the Model-View-ViewModel pattern for separation of concerns.

---

## Installation  

1. Clone the repository:
   ```bash
   git clone https://github.com/yoyobuzz/diary_app_kotlin.git
   cd diary_app_kotlin
   ```

2. Open the project in **Android Studio**.

3. Build the project and install it on an emulator or physical device:
   - Connect your device or start an emulator.
   - Run the app via the `Run` button in Android Studio.

---

## Database Structure  
The app uses **Room Database** to store entries locally. Each diary entry consists of:

- **ID**: Primary key (auto-generated)  
- **Title**: String  
- **Content**: String  
- **Emoji**: String (stores the emoji)  
- **Timestamp**: Date/time of the entry  

---

## Usage  

1. **Create a New Entry**:  
   - Tap the **+** button.
   - Enter the title, content, and choose an emoji representing your mood.
   - Tap **Save** to store the entry.

2. **Edit an Entry**:  
   - Select any entry from the list.
   - Modify the content or change the emoji.
   - Save the changes.

3. **Delete an Entry**:  
   - Long press an entry to delete it.

---

## Project Structure  

```plaintext
📦 diary_app_kotlin
 ┣ 📂data                # Contains Room database classes
 ┃ ┣ 📜DiaryDatabase.kt  # Room database instance
 ┃ ┣ 📜DiaryDao.kt       # DAO interface for CRUD operations
 ┃ ┗ 📜DiaryEntry.kt     # Data model class
 ┣ 📂ui                  # Contains UI-related code (activities/fragments)
 ┣ 📂viewmodel           # ViewModel classes for managing UI-related data
 ┣ 📜build.gradle        # Build configuration
 ┗ 📜AndroidManifest.xml # App manifest
```

---

## Code Snippet Example  

### DAO (DiaryDao.kt)
```kotlin
@Dao
interface DiaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: DiaryEntry)

    @Update
    suspend fun updateEntry(entry: DiaryEntry)

    @Delete
    suspend fun deleteEntry(entry: DiaryEntry)

    @Query("SELECT * FROM diary_entries ORDER BY timestamp DESC")
    fun getAllEntries(): LiveData<List<DiaryEntry>>
}
```
