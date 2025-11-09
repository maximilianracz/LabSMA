# Gotify for Android

A beautiful Android application for receiving and managing SMS messages as notifications, inspired by Gotify.

## Features

✨ **SMS Message Reception** - Automatically intercepts incoming SMS messages
📱 **Beautiful UI** - Modern Material Design 3 interface with Jetpack Compose
💾 **Local Storage** - Messages stored locally using Room Database
🔔 **Push Notifications** - System notifications for new messages
📋 **Message Management** - View, read, and delete messages
🎨 **Priority Support** - Messages have priority levels
📊 **Unread Counter** - Track unread messages at a glance

## Screenshots

The app features:
- **Message List Screen** - View all received SMS messages in a beautiful scrollable list
- **Message Detail Screen** - View full message details with sender information
- **Permission Screen** - User-friendly permission request interface

## How It Works

1. **Grant Permissions** - The app requests SMS and notification permissions
2. **Receive Messages** - When an SMS arrives, the app automatically:
   - Saves it to the local database
   - Shows a system notification
   - Marks it as unread
3. **View Messages** - Browse all messages in the main list
4. **Read Details** - Tap any message to view full details
5. **Manage Messages** - Delete individual messages or clear all

## Technical Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room
- **Navigation**: Navigation Compose
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36

## Project Structure

```
com.example.gotify/
├── data/
│   ├── Message.kt           # Message entity
│   ├── MessageDao.kt        # Database access object
│   ├── AppDatabase.kt       # Room database
│   └── MessageRepository.kt # Data repository
├── receiver/
│   └── SmsReceiver.kt       # SMS broadcast receiver
├── service/
│   └── NotificationService.kt # Notification management
├── viewmodel/
│   └── MessageViewModel.kt  # UI state management
├── ui/
│   ├── screens/
│   │   ├── MessageListScreen.kt   # Main message list
│   │   ├── MessageDetailScreen.kt # Message details
│   │   └── PermissionScreen.kt    # Permission request
│   └── theme/               # App theming
└── MainActivity.kt          # Main entry point

## Required Permissions

- **RECEIVE_SMS** - To receive incoming SMS messages
- **READ_SMS** - To read SMS message content
- **POST_NOTIFICATIONS** - To display system notifications (Android 13+)

## Setup & Installation

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle dependencies
4. Run on device or emulator
5. Grant required permissions when prompted

## Building

```bash
./gradlew assembleDebug
```

## Testing

To test the app, you can:
1. Use an Android device with a SIM card
2. Send SMS messages to the device from another phone
3. Messages will appear in the app with notifications

For emulator testing:
1. Use the emulator's SMS simulator
2. Send test messages through the extended controls

## Dependencies

- AndroidX Core KTX
- Jetpack Compose (Material 3)
- Room Database
- ViewModel & LiveData
- Navigation Compose
- Material Icons Extended

## License

This project is created for educational purposes.

## Author

Created as a Gotify-inspired Android application for managing SMS notifications.

---

**Note**: This app intercepts SMS messages and displays them as notifications. Make sure to grant all necessary permissions for full functionality.

