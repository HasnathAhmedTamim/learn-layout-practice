# Learn Layout Practice — README

This project is a Jetpack Compose Android app (practice repo) that demonstrates layouts, a scaffold with top/bottom bars, navigation tabs, and a simple network-driven user list. Below is an easy, step-by-step explanation of what you implemented in `MainActivity` and related files, what features are included, and how to run or test the app.

---

## What you implemented (high-level)

- A Compose-based main screen using a Scaffold (`Day6ScaffoldPractice`) with:
  - Top app bar (title)
  - Bottom navigation bar with 3 tabs (Home, Search, Profile)
  - Floating action button (FAB)
  - Content area that switches based on the selected tab
- The Home tab shows a network-fetched list of users (contacts) using Compose's `LazyColumn`.
- A small networking helper (`fetchContactsFromUrl`) that fetches JSON from a fake API and parses it into a `List<Contact>`.
- A `Contact` data class used by the UI.
- Updated icons to use `Icons.AutoMirrored.*` to avoid deprecation warnings and support RTL.
- Added `INTERNET` permission so the app can fetch remote data.

Files you likely added/updated
- `app/src/main/java/com/example/layoutpractice/MainActivity.kt` — contains `MainActivity`, `Day6ScaffoldPractice`, and `ContactListFromNetwork` composable.
- `app/src/main/java/com/example/layoutpractice/Contact.kt` — `data class Contact(val name: String, val phone: String)`.
- `app/src/main/java/com/example/layoutpractice/Network.kt` (or companion functions in `MainActivity.kt`) — `fetchContactsFromUrl` suspend function.
- `app/src/main/AndroidManifest.xml` — includes `<uses-permission android:name="android.permission.INTERNET" />`.

---

## Easy explanation of each part (what it does and why)

- `Day6ScaffoldPractice` (Scaffold):
  - Scaffold is a layout that organizes common UI parts: top bar, bottom bar, FAB, and content.
  - You used a `TopAppBar` for the app title, `NavigationBar` + `NavigationBarItem`s for the bottom tabs, and a `FloatingActionButton` for an action.
  - The main content area uses a `when (selectedTab)` switch to show different screens. For Home (tab 0) it shows the network-loaded list.

- `ContactListFromNetwork` (Compose UI):
  - This composable calls a suspend function to fetch JSON and exposes the result to Compose using `produceState` (so the network runs off the main thread and Compose recomposes when data arrives).
  - It displays the `List<Contact>` inside a `LazyColumn` with `items(contacts) { contact -> ... }`.
  - Each row is a `Card` showing `contact.name` and `contact.phone`.
  - `LazyColumn` is used so only visible rows are composed (better performance than Column for long lists).

- `fetchContactsFromUrl` (network helper):
  - Runs on `Dispatchers.IO` with `withContext` to avoid blocking the UI thread.
  - Reads JSON from a URL (for example, `https://jsonplaceholder.typicode.com/users`) and parses `name` and `phone` fields into `Contact` objects.
  - Returns an empty list on any error (simple, safe fallback).

- `Contact` data class:
  - Simple Kotlin data class with two fields: `name` and `phone`.
  - Used as the item type for the list UI.

- Icon update:
  - Replaced deprecated `Icons.Filled.List` with `Icons.AutoMirrored.Filled.List` (prevents deprecation warnings and supports RTL).

- Permission:
  - `INTERNET` permission is required for network requests; you added it in `AndroidManifest.xml`.

---

## Features implemented (short checklist)

- [x] Scaffold with TopAppBar, Bottom Navigation, FAB
- [x] Tab switching (Home / Search / Profile)
- [x] Home tab shows a network-fetched list of users
- [x] Network fetch helper (`fetchContactsFromUrl`) with JSON parsing
- [x] `Contact` data class
- [x] `LazyColumn` + `items` for efficient lists
- [x] Updated icons to AutoMirrored
- [x] Internet permission

---

## How to run / test locally

Using PowerShell in the project root (Windows):

```powershell
# Assemble a debug build
.\gradlew assembleDebug

# Or install the debug APK to a connected device/emulator
.\gradlew installDebug
```

You can also open the project in Android Studio and run the app on an emulator or device.

How to test the network list:
- Make sure your device/emulator has network access.
- Launch the app and open the Home tab (default). The list should load and show names and phone numbers from the remote JSON.
- If the network fails, the list will be empty (no crash).

---

## Notes & small improvements you can add later

- Use a `ViewModel` + `StateFlow` / `LiveData` instead of `produceState` for better lifecycle handling.
- Add a simple loading indicator while data is being fetched.
- Add error UI when the network request fails instead of showing an empty list.
- Use Retrofit + kotlinx.serialization or Moshi for cleaner network and JSON handling.

---

If you want, I can also:
- Insert a short loading spinner into `ContactListFromNetwork`.
- Move the network code into a `ViewModel` and show a simple error state.
- Create unit tests for the JSON parsing.

Tell me which of those you'd like and I will implement it next.
