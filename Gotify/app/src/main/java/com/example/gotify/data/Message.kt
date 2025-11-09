package com.example.gotify.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val message: String,
    val sender: String,
    val timestamp: Long,
    val priority: Int = 5,
    val isRead: Boolean = false
)

