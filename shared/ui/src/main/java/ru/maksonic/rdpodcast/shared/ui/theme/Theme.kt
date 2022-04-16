package ru.maksonic.rdpodcast.shared.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.maksonic.rdpodcast.shared.ui.theme.color.*
import ru.maksonic.rdpodcast.shared.ui.theme.shape.*
import ru.maksonic.rdpodcast.shared.ui.theme.typography.LocalRDTypography
import ru.maksonic.rdpodcast.shared.ui.theme.typography.RDTypography
import ru.maksonic.rdpodcast.shared.ui.theme.typography.typography

/**
 * @Author: maksonic on 04.03.2022
 */
@Composable
fun RDPodcastTheme(
    lightPalette: RDColor,
    darkPalette: RDColor,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkPalette else lightPalette


    CompositionLocalProvider(
        LocalRDColors provides colors,
        LocalRDComponentSize provides componentSize,
        LocalRDElevation provides elevations,
        LocalRDPadding provides paddings,
        LocalRDShape provides shapes,
        LocalRDTypography provides typography,
        content = content
    )
}

object RDTheme {
    val color: RDColor @Composable get() = LocalRDColors.current
    val componentSize: RDComponentSize @Composable get() = LocalRDComponentSize.current
    val elevation: RDElevation @Composable get() = LocalRDElevation.current
    val padding: RDPadding @Composable get() = LocalRDPadding.current
    val shape: RDShape @Composable get() = LocalRDShape.current
    val typography: RDTypography @Composable get() = LocalRDTypography.current
}

@Composable
fun MainTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    RDPodcastTheme(
        lightPalette = baseLightPalette,
        darkPalette = baseDarkPalette,
        darkTheme,
        content
    )
}

@Composable
fun HighContrastTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    RDPodcastTheme(
        lightPalette = baseHighContrastPalette,
        darkPalette = baseHighContrastPalette,
        darkTheme,
        content
    )
}

