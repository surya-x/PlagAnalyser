package com.example.plaganalyser

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextTable(
    @PrimaryKey val id: Int,
    var text: String
)

@Entity(primaryKeys = ["id", "word"])
data class HashTable(
    @NonNull var id: Int,
    @NonNull var word: String,
    @NonNull val frequency: Int
)