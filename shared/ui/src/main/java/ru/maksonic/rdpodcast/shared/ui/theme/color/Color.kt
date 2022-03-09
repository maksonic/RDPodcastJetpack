package ru.maksonic.rdpodcast.shared.ui.theme.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * @Author: maksonic on 04.03.2022
 */
val LocalRDColors = staticCompositionLocalOf<RDColor> {
    error("No colors provided")
}

data class RDColor(
    val primary: Color,
    val primaryVariant: Color,
    val onPrimary: Color,
    val secondary: Color,
    val secondaryVariant: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val divider: Color,
    val error: Color,
    val onError: Color,
    val transparent: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val tertiaryText: Color,
)

val Black = Color(0xFF000000)
val CarmineRed = Color(0xFFB00020)
val DimGray = Color(0xFFEDEDED)
val GainsboroGray = Color(0xFFDCDCDC)
val Nero = Color(0xFF212121)
val Ripple = Color(0x0AFFFFFF)
val ShadowLight = Color(0x1FFFFFFF)
val ShadowDark = Color(0x52000000)
val Solitude = Color(0xFFF7F7F7)
val ShuttleGray = Color(0xFF65676B)
val Transparent = Color(0x00FFFFFF)
val White = Color(0xFFFFFFFF)