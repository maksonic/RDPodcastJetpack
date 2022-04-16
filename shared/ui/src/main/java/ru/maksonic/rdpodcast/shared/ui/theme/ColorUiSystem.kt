package ru.maksonic.rdpodcast.shared.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.maksonic.rdpodcast.core.settings.AppTheme
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseDarkPalette
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseHighContrastPalette
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseLightPalette

/**
 * @Author: maksonic on 10.03.2022
 */
@Composable
fun InitSystemComponentsColor(
    isDarkMode: Boolean,
    themeType: State<AppTheme>,
    actualBackgroundColor: Color,
    systemUiController: SystemUiController = rememberSystemUiController()
) {
    val minLuminanceForDarkIcons = .5f

    SideEffect {
        systemUiController.setStatusBarColor(
            color = setSystemComponentColor(isDarkMode, themeType),
            darkIcons = actualBackgroundColor.luminance() > minLuminanceForDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = setSystemComponentColor(isDarkMode, themeType),
            darkIcons = actualBackgroundColor.luminance() > minLuminanceForDarkIcons,
            navigationBarContrastEnforced = false
        )
    }
}

private fun setSystemComponentColor(
    isDarkMode: Boolean,
    themeType: State<AppTheme>
): Color = when (themeType.value) {
    AppTheme.LIGHT -> baseLightPalette.transparent
    AppTheme.DARK -> baseDarkPalette.background
    AppTheme.HIGH_CONTRAST -> baseHighContrastPalette.background
    AppTheme.SYSTEM -> {
        if (isDarkMode) baseDarkPalette.background else baseLightPalette.transparent
    }
}
