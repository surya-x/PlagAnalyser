package com.example.plaganalyser

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class WordViewModel(application: Application): ViewModel() {

    private val repository: WordRepository
    private val id1 = 1
    private val id2 = 2

    init {
        val textDao = WordDatabase.getInstance(application).getTextDao()
        val hashDao = WordDatabase.getInstance(application).getHashDao()
        repository = WordRepository(textDao, hashDao)
    }

//    fun onCalculatePlagiarism(text1: String, text2: String){}
    fun onSubmit(text1: String, text2: String) {
        // Inserting data into database
        repository.insertText(TextTable(id1, text1))
        repository.insertText(TextTable(id2, text2))

        Log.d("DEBUG", repository.getText(1)[0])
        Log.d("DEBUG", repository.getText(2)[0])
    }
}