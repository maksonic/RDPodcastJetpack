package ru.maksonic.rdpodcast.shared.ui.theme.shape

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author: maksonic on 05.03.2022
 */
val LocalRDComponentSize = staticCompositionLocalOf<RDComponentSize> {
    error("No component size provided")
}

data class RDComponentSize(
    val btnNav: Dp,
    val btnPrimaryHeight: Dp,
    val btnModalSheetItem: Dp
)

val componentSize = RDComponentSize(
    btnNav = 24.dp,
    btnPrimaryHeight = 54.dp,
    btnModalSheetItem = 48.dp
)