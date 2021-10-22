package com.example.plaganalyser

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class WordViewModel(application: Application): AndroidViewModel(application) {

    init {
        val textDao = WordDatabase.getD
    }
    val id1 = 1
    val id2 = 2
    private val textDao: TextDao
    private val repository: WordRepository()

    fun onCalculatePlagarism(text1: String, text2: String)
}