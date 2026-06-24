# 📅 Schedule Notifier App

A modern Android application built using **Kotlin** and **Jetpack Compose** that allows users to schedule an event by selecting a date and time and instantly receive a notification confirmation.

---

# ✨ Features

* ✅ Select Date using DatePickerDialog
* ✅ Select Time using TimePickerDialog
* ✅ Android 13+ Notification Permission Support
* ✅ Notification Channel Creation
* ✅ Instant Schedule Confirmation Notification
* ✅ Material 3 UI Components
* ✅ Jetpack Compose State Management
* ✅ User Friendly Interface
* ✅ Responsive Layout Design

---

# 🛠 Tech Stack

| Technology                | Purpose                   |
| ------------------------- | ------------------------- |
| Kotlin                    | Programming Language      |
| Jetpack Compose           | UI Development            |
| Material 3                | User Interface Components |
| NotificationCompat        | Notifications             |
| NotificationManagerCompat | Notification Management   |
| DatePickerDialog          | Date Selection            |
| TimePickerDialog          | Time Selection            |
| Android Studio            | Development Environment   |

---

# 📱 Screenshots

<p align="center">

<img src="screenshots/schedule1.jpeg" width="260"/>

   

<img src="screenshots/schedule2.jpeg" width="260"/>

</p>

---

# 📂 Project Structure

```text
app
│
├── MainActivity.kt
├── NotificationHelper.kt
│
├── screenshots
│    ├── home.jpeg
│    └── notification.jpeg
```

---

# 🚀 Application Workflow

### Step 1 : Open App

The application launches and requests notification permission on Android 13+ devices.

---

### Step 2 : Pick Date

Users can choose a preferred date using the Date Picker dialog.

---

### Step 3 : Pick Time

Users select a time using the Time Picker dialog.

---

### Step 4 : Confirm Schedule

After selecting both date and time, click

```kotlin
Confirm Schedule
```

button.

---

### Step 5 : Receive Notification

Example Notification:

```text
Event Scheduled

Scheduled on 22/06/2026 at 18:30
```

---

# 🔔 Notification Features

### Notification Channel

```kotlin
NotificationHelper.createNotificationChannel(this)
```

Required for Android 8.0+.

### Runtime Permission

```kotlin
POST_NOTIFICATIONS
```

Supported for Android 13+.

### Notification Display

```kotlin
NotificationHelper.showNotification(
context,
title,
message
)
```

---

# 📌 Important Concepts Used

## Jetpack Compose

State Management

```kotlin
remember {
mutableStateOf()
}
```

---

## DatePickerDialog

```kotlin
DatePickerDialog(
context,
listener,
year,
month,
day
)
```

---

## TimePickerDialog

```kotlin
TimePickerDialog(
context,
listener,
hour,
minute,
true
)
```

---

## NotificationCompat

```kotlin
NotificationCompat.Builder()
```

---

# 🎯 Learning Outcomes

This project demonstrates:

* Jetpack Compose Fundamentals

* Android Notifications

* Runtime Permissions

* Date and Time Handling

* Material 3 Design

* State Management

* Dialog Components

* Android App Development Best Practices

---

# ⚙️ Installation

Clone Repository

```bash
git clone https://github.com/yourusername/ScheduleNotifier.git
```

Open in Android Studio.

Sync Gradle.

Run on Emulator or Physical Device.

---

# 👨‍💻 Author

**Vishal Dhiman**

B.Tech Student

Android Developer

Kotlin Enthusiast

---

# ⭐ Support

If you like this project, consider giving it a **Star ⭐** on GitHub.
