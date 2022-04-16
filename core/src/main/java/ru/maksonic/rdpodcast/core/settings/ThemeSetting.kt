package ru.maksonic.rdpodcast.core.settings

import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import ru.maksonic.rdpodcast.core.provider.ResourceProvider
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @Author: maksonic on 29.03.2022
 */
enum class AppTheme { LIGHT, DARK, HIGH_CONTRAST, SYSTEM }

interface ThemeSetting {
    val themeStream: MutableStateFlow<AppTheme>
    var theme: AppTheme
    fun setupTheme(themeId: Int): AppTheme

    class ThemeSettingPreference @Inject constructor(
        preferences: ResourceProvider
    ) : ThemeSetting {
        private companion object {
            private const val themeDelegate = "delegate_app_theme"
        }

        override val themeStream: MutableStateFlow<AppTheme>
        override var theme: AppTheme by AppThemePreferenceDelegate(
            themeDelegate,
            AppTheme.SYSTEM
        )

        override fun setupTheme(themeId: Int): AppTheme = AppTheme.values()[themeId]
        private val preferences = preferences.provideSharedPreferences(preferences.themePrefs)

        init {
            themeStream = MutableStateFlow(theme)
        }

        inner class AppThemePreferenceDelegate(
            private val name: String, private val default: AppTheme
        ) : ReadWriteProperty<Any?, AppTheme> {
            override fun getValue(thisRef: Any?, property: KProperty<*>): AppTheme {
                return setupTheme(preferences.getInt(name, default.ordinal))
            }

            override fun setValue(thisRef: Any?, property: KProperty<*>, value: AppTheme) {
                themeStream.value = value
                preferences.edit {
                    putInt(name, value.ordinal)
                }
            }
        }
    }
}