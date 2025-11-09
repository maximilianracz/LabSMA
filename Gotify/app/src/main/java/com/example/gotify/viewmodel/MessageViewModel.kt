package com.example.gotify.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.gotify.data.AppDatabase
import com.example.gotify.data.Message
import com.example.gotify.data.MessageRepository
import com.example.gotify.service.NotificationService
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MessageViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: MessageRepository
    
    val allMessages: StateFlow<List<Message>>
    val unreadCount: StateFlow<Int>
    
    init {
        val database = AppDatabase.getDatabase(application)
        repository = MessageRepository(database.messageDao())
        
        allMessages = repository.allMessages.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
        
        unreadCount = repository.unreadCount.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )
    }
    
    fun markAsRead(messageId: Long) {
        viewModelScope.launch {
            repository.markAsRead(messageId)
        }
    }
    
    fun deleteMessage(message: Message) {
        viewModelScope.launch {
            repository.deleteMessage(message)
        }
    }
    
    fun deleteAllMessages() {
        viewModelScope.launch {
            repository.deleteAllMessages()
        }
    }
    
    suspend fun getMessageById(id: Long): Message? {
        return repository.getMessageById(id)
    }
    
    fun addTestMessage() {
        viewModelScope.launch {
            val testMessage = com.example.gotify.utils.TestMessageGenerator.generateTestMessage()
            val messageId = repository.insertMessage(testMessage)
            
            // Show notification for the test message
            NotificationService.showNotification(
                context = getApplication(),
                messageId = messageId,
                title = testMessage.title,
                content = testMessage.message,
                sender = testMessage.sender
            )
        }
    }
}

