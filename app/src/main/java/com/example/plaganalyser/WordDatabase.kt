package com.example.plaganalyser

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TextTable::class, HashTable::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase() {
    abstract fun getTextDao(): TextDao
    abstract fun getHashDao(): HashDao

    // Companion: members  of this class can be called without instantiating the class
    companion object {
        @Volatile
        // Creating nullable variable INSTANCE
        var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            // Using the function "synchronized" so that only one thread can access this code at a time;
            // to avoid multiple reference of DB at the same time
            synchronized(this) {
                var instance = INSTANCE
                // Creating the instance of the Database if not present already.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordDatabase::class.java,
                        "WordDatabase"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}