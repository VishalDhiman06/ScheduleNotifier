package com.lpu.schedulenotifier

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

class MainActivity : ComponentActivity() {

    // Launcher to request POST_NOTIFICATIONS permission (Android 13+)
    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the notification channel once, when the app starts
        NotificationHelper.createNotificationChannel(this)

        // Ask for notification permission on Android 13+ (required at runtime)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ScheduleScreen()
                }
            }
        }
    }

    @Composable
    fun ScheduleScreen() {
        val context = this

        var selectedDate by remember { mutableStateOf("No date selected") }
        var selectedTime by remember { mutableStateOf("No time selected") }

        var day by remember { mutableStateOf(0) }
        var month by remember { mutableStateOf(0) }
        var year by remember { mutableStateOf(0) }
        var hour by remember { mutableStateOf(0) }
        var minute by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Schedule an Event",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ---------- Selected date/time display ----------
            Text(text = "Date: $selectedDate", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Time: $selectedTime", fontSize = 16.sp)

            Spacer(modifier = Modifier.height(24.dp))

            // ---------- Pick Date Button ----------
            Button(
                onClick = {
                    val calendar = Calendar.getInstance()
                    DatePickerDialog(
                        context,
                        { _, y, m, d ->
                            year = y
                            month = m
                            day = d
                            // Month is 0-indexed in Calendar, so +1 for display
                            selectedDate = String.format("%02d/%02d/%04d", d, m + 1, y)
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                    ).show()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Pick Date")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ---------- Pick Time Button ----------
            Button(
                onClick = {
                    val calendar = Calendar.getInstance()
                    TimePickerDialog(
                        context,
                        { _, h, m ->
                            hour = h
                            minute = m
                            selectedTime = String.format("%02d:%02d", h, m)
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                    ).show()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Pick Time")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // ---------- Confirm Button ----------
            Button(
                onClick = {
                    if (selectedDate == "No date selected" || selectedTime == "No time selected") {
                        return@Button
                    }

                    val scheduleDetails = "Scheduled on $selectedDate at $selectedTime"

                    // Show the notification immediately with the chosen schedule details
                    NotificationHelper.showNotification(
                        context = context,
                        title = "Event Scheduled",
                        message = scheduleDetails
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirm Schedule")
            }
        }
    }
}




