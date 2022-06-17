package com.example.appcolorblindness.data.preferences

import android.content.Context

object ColorBlindnessData {
    private const val COLOR_BLINDNESS_PREFERENCES = "Creditcob"
    private const val USERNAME_KEY = "username"
    private const val RESPONSE_KEY = "response"
    private const val QUESTION_KEY = "response"
    const val APP_INTRODUCTION_KEY = "app-intro"

    fun writeUsername(context: Context, username: String) {
        writeStringPreferences(context, USERNAME_KEY, username)
    }

    fun readUsername(context: Context): String {
        return readStringPreferences(context, USERNAME_KEY, "").toString()
    }

    fun writeCorrectResponse(context: Context, value: Int) {
        writeIntPreferences(context, RESPONSE_KEY, value)
    }

    fun readCorrectQuestions(context: Context): Int? {
        return readIntPreferences(context, RESPONSE_KEY, 0)
    }

    fun writeQuestions(context: Context, value: Int) {
        writeIntPreferences(context, QUESTION_KEY, value)
    }

    fun readQuestions(context: Context): Int? {
        return readIntPreferences(context, QUESTION_KEY, 0)
    }

    private fun readStringPreferences(context: Context, key: String, value: String): String? {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, value)
    }

    private fun writeStringPreferences(context: Context, key: String, value: String) {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.edit().putString(key, value).apply()
    }

    private fun readIntPreferences(context: Context, key: String, value: Int): Int? {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(key, value)
    }

    private fun writeIntPreferences(context: Context, key: String, value: Int) {
        val sharedPreferences =
            context.getSharedPreferences(COLOR_BLINDNESS_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.edit().putInt(key, value).apply()
    }
}