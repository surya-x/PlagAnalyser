package com.example.plaganalyser

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

class WordRepository(private val textDao: TextDao, private val hashDao: HashDao) {

    /* Text data inputted by user */

    // The suspend modifier tells the compiler that this needs to be called
    // from a coroutine or another suspending function.
    suspend fun getText(id: Int): List<String>{
        return textDao.getText(id)
    }
    suspend fun insertText(text: TextTable){
        textDao.insertText(text)
    }
    suspend fun deleteText(text: TextTable){
        textDao.deleteText(text)
    }


    
    /* Data stored in hash table created by the app */
    suspend fun insertHash(hash: HashTable){
        hashDao.insertHash(hash)
    }
    suspend fun deleteHash(hash: HashTable){
        hashDao.deleteHash(hash)
    }
    suspend fun incrementHashFrequency(id: Int, value: String){
        hashDao.incrementHashFrequency(id, value)
    }
    suspend fun getHashFrequency(id: Int, value: String): List<Int>{
        return hashDao.getHashFrequency(id, value)
    }
    suspend fun findHashWord(id: Int, value: String): Int{
        return hashDao.findHashWord(id, value)
    }

}
