package com.example.gotify.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import com.example.gotify.data.AppDatabase
import com.example.gotify.data.Message
import com.example.gotify.service.NotificationService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SmsReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            
            messages?.forEach { smsMessage ->
                val sender = smsMessage.displayOriginatingAddress ?: "Unknown"
                val messageBody = smsMessage.messageBody ?: ""
                val timestamp = smsMessage.timestampMillis
                
                Log.d("SmsReceiver", "Received SMS from $sender: $messageBody")
                
                // Save to database
                val database = AppDatabase.getDatabase(context)
                val message = Message(
                    title = "SMS from $sender",
                    message = messageBody,
                    sender = sender,
                    timestamp = timestamp,
                    priority = 5,
                    isRead = false
                )
                
                CoroutineScope(Dispatchers.IO).launch {
                    val messageId = database.messageDao().insertMessage(message)
                    
                    // Show notification
                    NotificationService.showNotification(
                        context = context,
                        messageId = messageId,
                        title = "SMS from $sender",
                        content = messageBody,
                        sender = sender
                    )
                }
            }
        }
    }
}

