package ru.maksonic.rdpodcast.shared.ui.theme.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme
import ru.maksonic.rdpodcast.shared.ui.theme.color.RDColor

/**
 * @Author: maksonic on 04.03.2022
 */
val LocalRDTypography = staticCompositionLocalOf<RDTypography> {
    error("No font provided")
}

data class RDTypography(
    val body: TextStyle,
    val title: TextStyle,
    val header: TextStyle,
    val toolbarTitle: TextStyle,
    val display: TextStyle,
    val caption: TextStyle
)

val typography = RDTypography(
    body = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    title = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    header = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    toolbarTitle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    display = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold
    ),
    caption = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )
)
