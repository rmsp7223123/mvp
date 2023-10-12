package com.example.mvp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user_id: String,
    val user_pw: String,
    val user_name: String
)