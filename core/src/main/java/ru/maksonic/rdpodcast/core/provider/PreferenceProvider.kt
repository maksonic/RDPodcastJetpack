package ru.maksonic.rdpodcast.core.provider

import android.content.SharedPreferences

/**
 * @Author: maksonic on 29.03.2022
 */
interface PreferenceProvider {
    val themePrefs get() = "prefs_select_app_theme"
    fun provideSharedPreferences(name: String): SharedPreferences
}