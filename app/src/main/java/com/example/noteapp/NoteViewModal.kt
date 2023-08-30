package com.example.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application): AndroidViewModel(application) {
    val allNotes: LiveData<List<Note>>
    val respository: NoteRespository
    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        respository = NoteRespository(dao)
        allNotes = respository.allNotes
    }
    fun deleteNote(note:Note) = viewModelScope.launch ( Dispatchers.IO ) {
        respository.delete(note)
    }
    fun updateNote(note:Note) = viewModelScope.launch ( Dispatchers.IO ) {
        respository.update(note)
    }
    fun addNote(note:Note) = viewModelScope.launch ( Dispatchers.IO ) {
        respository.insert(note)
    }
}