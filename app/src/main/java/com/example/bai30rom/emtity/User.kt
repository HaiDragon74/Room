package com.example.bai30rom.emtity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val fistName: String,
    val lastName: String,
    val age: String
)