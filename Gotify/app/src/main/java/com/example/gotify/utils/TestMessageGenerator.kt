package com.example.gotify.utils

import com.example.gotify.data.Message
import kotlin.random.Random

/**
 * Utility class for generating test messages
 * Useful for testing and development
 */
object TestMessageGenerator {
    
    private val senders = listOf(
        "+1234567890",
        "+9876543210",
        "John Doe",
        "Jane Smith",
        "Tech Support",
        "Banking Alert",
        "Delivery Service"
    )
    
    private val messages = listOf(
        "Hello! How are you doing today?",
        "Your package has been delivered successfully.",
        "Meeting scheduled for 3 PM tomorrow.",
        "Don't forget to pick up groceries.",
        "Your verification code is 123456",
        "Congratulations! You've won a prize.",
        "System maintenance scheduled for tonight.",
        "Your order has been confirmed.",
        "New message from your friend!",
        "Reminder: Doctor appointment at 2 PM"
    )
    
    /**
     * Generate a random test message
     */
    fun generateTestMessage(): Message {
        return Message(
            title = "SMS from ${senders.random()}",
            message = messages.random(),
            sender = senders.random(),
            timestamp = System.currentTimeMillis() - Random.nextLong(0, 7 * 24 * 60 * 60 * 1000),
            priority = Random.nextInt(1, 11),
            isRead = Random.nextBoolean()
        )
    }
    
    /**
     * Generate multiple test messages
     */
    fun generateTestMessages(count: Int): List<Message> {
        return List(count) { generateTestMessage() }
    }
}

