package com.example.plaganalyser

import androidx.annotation.WorkerThread
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

class WordRepository(private val textDao: TextDao, private val hashDao: HashDao) {

    /* Text data inputted by user */

    // The suspend modifier tells the compiler that this needs to be called
    // from a coroutine or another suspending function.
    fun getText(id: Int): List<String>{
        return textDao.getText(id)
    }
    fun insertText(text: TextTable){
        textDao.insertText(text)
    }
    fun deleteText(text: TextTable){
        textDao.deleteText(text)
    }



    /* Data stored in hash table created by the app */
    fun insertHash(hash: HashTable){
        hashDao.insertHash(hash)
    }
    fun deleteHash(hash: HashTable){
        hashDao.deleteHash(hash)
    }
    fun incrementHashFrequency(id: Int, value: String){
        hashDao.incrementHashFrequency(id, value)
    }
    fun getHashFrequency(id: Int, value: String): List<Int>{
        return hashDao.getHashFrequency(id, value)
    }
    fun findHashWord(id: Int, value: String): Int{
        return hashDao.findHashWord(id, value)
    }

}
