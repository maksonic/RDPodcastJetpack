package ru.maksonic.rdpodcast.shared.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import ru.maksonic.rdpodcast.shared.ui.theme.color.LocalRDColors
import ru.maksonic.rdpodcast.shared.ui.theme.color.RDColor
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseDarkPalette
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseLightPalette
import ru.maksonic.rdpodcast.shared.ui.theme.shape.*
import ru.maksonic.rdpodcast.shared.ui.theme.typography.LocalRDTypography
import ru.maksonic.rdpodcast.shared.ui.theme.typography.RDTypography
import ru.maksonic.rdpodcast.shared.ui.theme.typography.typography

/**
 * @Author: maksonic on 04.03.2022
 */
@Composable
fun RDPodcastTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        baseDarkPalette
    } else {
        baseLightPalette
    }

    CompositionLocalProvider(
        LocalRDColors provides colors,
        LocalRDTypography provides typography,
        LocalRDShape provides shapes,
        LocalRDComponentSize provides componentSize,
        content = content
    )
}

object RDTheme {
    val color: RDColor @Composable get() = LocalRDColors.current
    val typography: RDTypography @Composable get() = LocalRDTypography.current
    val shape: RDShape @Composable get() = LocalRDShape.current
    val componentSize: RDComponentSize @Composable get() = LocalRDComponentSize.current
}