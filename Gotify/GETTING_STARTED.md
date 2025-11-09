# Getting Started with Gotify Android

Welcome! This guide will help you set up and use the Gotify Android application.

## 🚀 Quick Start

### 1. First Launch
When you first launch the app, you'll see a permission request screen with a beautiful interface explaining why permissions are needed.

### 2. Grant Permissions
The app needs three permissions to work:
- **Receive SMS** - To detect incoming text messages
- **Read SMS** - To display the message content
- **Post Notifications** - To show alerts (Android 13+)

Tap the "Grant Permissions" button and accept all permissions when prompted.

### 3. Start Receiving Messages
Once permissions are granted:
- The app will automatically intercept all incoming SMS messages
- Each message is saved to a local database
- You'll receive a system notification for each new message
- Messages appear in the main list screen

## 📱 Using the App

### Main Screen (Message List)
- **View Messages**: Scroll through all received SMS messages
- **Unread Badge**: See the count of unread messages in the top bar
- **Tap a Message**: Open detailed view
- **Menu Button**: Access additional options

### Message Details
- **Full Message**: View the complete message content
- **Sender Info**: See who sent the message
- **Timestamp**: View when the message was received
- **Priority**: Check the message priority (1-10 scale)
- **Mark as Read**: Automatically marked when opened
- **Delete**: Remove individual messages

### Managing Messages
- **Delete All**: Use the menu (⋮) in the top bar → "Delete all messages"
- **Delete One**: Open message details → Tap delete icon (🗑️)

## 🧪 Testing the App

### On a Real Device
1. Install the app on a device with a SIM card
2. Send an SMS to that device from another phone
3. The message will appear in Gotify with a notification

### On an Emulator
1. Open Android Studio's Extended Controls (⋯ button)
2. Navigate to Phone → SMS messages
3. Send a test SMS to the emulator
4. The message will appear in the app

### Using Test Data (Developer Mode)
The app includes a `TestMessageGenerator` utility for testing:
```kotlin
// Add this code temporarily in MainActivity to generate test data
val database = AppDatabase.getDatabase(this)
CoroutineScope(Dispatchers.IO).launch {
    val testMessages = TestMessageGenerator.generateTestMessages(5)
    testMessages.forEach { database.messageDao().insertMessage(it) }
}
```

## 🎨 Features Overview

### 1. Beautiful UI
- Modern Material Design 3
- Smooth animations
- Intuitive navigation
- Dark/Light theme support (follows system)

### 2. Smart Notifications
- System notifications for new messages
- Tap notification to open app
- Auto-cancel when read
- High priority for visibility

### 3. Message Status
- **Unread**: Blue dot indicator, elevated card
- **Read**: Flat appearance, muted colors
- Unread counter in top bar

### 4. Data Management
- All data stored locally (no cloud)
- Messages persist between app launches
- Efficient Room database
- Automatic timestamp sorting (newest first)

## 🔧 Troubleshooting

### Messages Not Appearing?
1. Check that SMS permissions are granted
2. Go to Settings → Apps → Gotify → Permissions
3. Ensure "SMS" and "Notifications" are allowed

### Notifications Not Showing?
1. Check notification permission (Android 13+)
2. Go to Settings → Apps → Gotify → Notifications
3. Ensure notifications are enabled
4. Check "Do Not Disturb" mode

### App Crashes on Launch?
1. Clear app data: Settings → Apps → Gotify → Storage → Clear Data
2. Reinstall the app
3. Check Android version (requires Android 7.0+)

## 📊 Technical Details

### Database Schema
```kotlin
Message {
    id: Long (Auto-generated)
    title: String
    message: String
    sender: String
    timestamp: Long
    priority: Int (1-10)
    isRead: Boolean
}
```

### Navigation Flow
```
Permission Screen → Message List → Message Details
                                 ↓
                            Delete → Back to List
```

### Data Flow
```
SMS Received → SmsReceiver → Database + Notification
                                      ↓
                                  ViewModel → UI Update
```

## 🔐 Privacy & Security

- **Local Storage Only**: All messages stored on device
- **No Internet Required**: App works completely offline
- **No Data Collection**: No analytics or tracking
- **Standard Permissions**: Only SMS and notification access
- **User Control**: Delete messages anytime

## 💡 Tips & Best Practices

1. **Manage Storage**: Regularly delete old messages to save space
2. **Check Permissions**: If the app stops working, verify permissions
3. **Read Messages**: Tap messages to mark them as read
4. **Quick Delete**: Swipe pattern (future feature!)
5. **Backup**: The app doesn't backup messages; use Android's backup

## 🎯 Use Cases

- **SMS Inbox Alternative**: Replace the default messaging app for viewing
- **Message Archive**: Keep important SMS messages organized
- **Notification Hub**: Central place for all SMS notifications
- **Privacy Tool**: View SMS without keeping them in default app
- **Testing/Development**: Test SMS functionality in your apps

## 📱 Compatibility

- **Minimum**: Android 7.0 (API 24)
- **Target**: Android 14+ (API 36)
- **Recommended**: Android 10+ for best experience
- **Tested On**: 
  - Android 10, 11, 12, 13, 14
  - Various device manufacturers

## 🐛 Known Issues

- Messages appear in both Gotify and default SMS app (by design)
- Large messages (MMS) may not display correctly
- Group messages show individual sender only
- No SMS sending capability (receive only)

## 🚀 Future Enhancements

Potential features for future versions:
- [ ] Search messages
- [ ] Filter by sender
- [ ] Export messages
- [ ] Message categories
- [ ] Swipe to delete
- [ ] Custom notification sounds
- [ ] SMS reply capability
- [ ] Dark mode toggle
- [ ] Message statistics

## 📞 Support

For issues or questions:
1. Check this guide first
2. Review the main README.md
3. Check Android Studio logcat for errors
4. Verify device compatibility

## 🎓 Learning Resources

This project demonstrates:
- Jetpack Compose UI
- Room Database
- MVVM Architecture
- Broadcast Receivers
- Navigation Component
- Material Design 3
- Kotlin Coroutines
- StateFlow & LiveData

---

**Enjoy using Gotify! 📱✨**

Made with ❤️ for Android developers

