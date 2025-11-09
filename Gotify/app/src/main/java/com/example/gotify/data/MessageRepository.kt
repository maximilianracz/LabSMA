package com.example.gotify.data

import kotlinx.coroutines.flow.Flow

class MessageRepository(private val messageDao: MessageDao) {
    
    val allMessages: Flow<List<Message>> = messageDao.getAllMessages()
    val unreadCount: Flow<Int> = messageDao.getUnreadCount()
    
    suspend fun getMessageById(id: Long): Message? {
        return messageDao.getMessageById(id)
    }
    
    suspend fun insertMessage(message: Message): Long {
        return messageDao.insertMessage(message)
    }
    
    suspend fun updateMessage(message: Message) {
        messageDao.updateMessage(message)
    }
    
    suspend fun deleteMessage(message: Message) {
        messageDao.deleteMessage(message)
    }
    
    suspend fun deleteAllMessages() {
        messageDao.deleteAllMessages()
    }
    
    suspend fun markAsRead(id: Long) {
        messageDao.markAsRead(id)
    }
}

