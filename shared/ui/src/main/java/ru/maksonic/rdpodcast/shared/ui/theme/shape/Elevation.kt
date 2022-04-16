package ru.maksonic.rdpodcast.shared.ui.theme.shape

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author: maksonic on 29.03.2022
 */
val LocalRDElevation = staticCompositionLocalOf<RDElevation> {
    error("No component size provided")
}

data class RDElevation(
    val elevationDisable: Dp,
    val dp1: Dp,
    val dp2: Dp,
    val dp4: Dp,
    val dp8: Dp,
    val dp16: Dp,
)

val elevations = RDElevation(
    elevationDisable = 0.dp,
    dp1 = 1.dp,
    dp2 = 2.dp,
    dp4 = 4.dp,
    dp8 = 8.dp,
    dp16 = 16.dp,
)