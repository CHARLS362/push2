package com.example.push2.data

data class Notification(
    val id: Int,
    val title: String,
    val body: String,
    val timestamp: Long = System.currentTimeMillis()
)
