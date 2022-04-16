package ru.maksonic.rdpodcast.shared.ui.theme.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @Author: maksonic on 04.03.2022
 */
val LocalRDShape = staticCompositionLocalOf<RDShape> {
    error("No shapes provided")
}

data class RDShape(
    val cornerNone: Shape,
    val cornerSmall: Shape,
    val cornerNormal: Shape,
    val cornerBig: Shape,
    val cornerExtra: Shape,
)

val shapes = RDShape(
    cornerNone = RoundedCornerShape(0.dp),
    cornerSmall = RoundedCornerShape(4.dp),
    cornerNormal = RoundedCornerShape(8.dp),
    cornerBig = RoundedCornerShape(16.dp),
    cornerExtra = RoundedCornerShape(24.dp),
)