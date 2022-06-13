package com.example.appcolorblindness.data

import android.content.Context

object ColorBlindnessData {
    private const val COLOR_BLINDNESS_PREFERENCES = "Creditcob"
    const val USERNAME_KEY = "username"
    const val APP_INTRODUCTION_KEY = "app-intro"

    fun updateUsername(context: Context, username: String) {
        writePreferences(context, USERNAME_KEY, username)
    }

    fun readUsername(context: Context): String {
        return readPreferences(context, USERNAME_KEY, "").toString()
    }

    private fun readPreferences(context: Context, key: String, value: String): String? {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, value)
    }

    private fun writePreferences(context: Context, key: String, value: String) {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.edit().putString(key, value).apply()
    }
}