package com.example.noteapp

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:Note)
    @Update
    fun update(note:Note)
    @Delete
    fun delete(note: Note)
    @Query("SELECT * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

}