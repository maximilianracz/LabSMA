package com.example.gotify

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gotify.service.NotificationService
import com.example.gotify.ui.screens.MessageDetailScreen
import com.example.gotify.ui.screens.MessageListScreen
import com.example.gotify.ui.screens.PermissionScreen
import com.example.gotify.ui.theme.GotifyTheme
import com.example.gotify.viewmodel.MessageViewModel

class MainActivity : ComponentActivity() {
    
    private val viewModel: MessageViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Create notification channel
        NotificationService.createNotificationChannel(this)
        
        setContent {
            GotifyTheme {
                GotifyApp(viewModel = viewModel)
            }
        }
    }
    
    private fun hasRequiredPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECEIVE_SMS
        ) == PackageManager.PERMISSION_GRANTED &&
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED
    }
}

@Composable
fun GotifyApp(viewModel: MessageViewModel) {
    val navController = rememberNavController()
    var hasPermissions by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        // Check permissions
        hasPermissions = true // Will be checked properly by PermissionScreen
    }
    
    NavHost(
        navController = navController,
        startDestination = "permissions"
    ) {
        composable("permissions") {
            PermissionScreen(
                onPermissionsGranted = {
                    navController.navigate("messages") {
                        popUpTo("permissions") { inclusive = true }
                    }
                }
            )
        }
        
        composable("messages") {
            MessageListScreen(
                viewModel = viewModel,
                onMessageClick = { messageId ->
                    navController.navigate("message/$messageId")
                }
            )
        }
        
        composable(
            route = "message/{messageId}",
            arguments = listOf(
                navArgument("messageId") { type = NavType.LongType }
            )
        ) { backStackEntry ->
            val messageId = backStackEntry.arguments?.getLong("messageId") ?: return@composable
            MessageDetailScreen(
                messageId = messageId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}