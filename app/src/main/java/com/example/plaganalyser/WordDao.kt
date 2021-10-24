package com.example.plaganalyser

import androidx.room.*

@Dao
interface TextDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertText(text: TextTable)

    @Delete
    fun deleteText(text: TextTable)

    @Query("SELECT text FROM TextTable WHERE id = :id LIMIT 1")
    fun getText(id: Int): List<String>
}

@Dao
interface HashDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHash(hash: HashTable)

    @Delete
    fun deleteHash(hash: HashTable)

    @Query("UPDATE HashTable SET frequency = frequency + 1 WHERE id = :id AND word = :value")
    fun incrementHashFrequency(id: Int, value: String)

    @Query("Select frequency from HashTable WHERE id = :id AND word = :value")
    fun getHashFrequency(id: Int, value: String): List<Int>

    @Query("SELECT COUNT(*) FROM (SELECT 1 FROM HashTable WHERE id = :id AND word = :value)")
    fun findHashWord(id: Int, value: String): Int
}