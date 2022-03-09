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
    val padding4: Dp,
    val padding8: Dp,
    val padding16: Dp,
    val padding24: Dp,
    val padding32: Dp,
    val padding54: Dp,
    val padding64: Dp,
    val padding72: Dp,
    val cornerNone: Shape,
    val cornerSmall: Shape,
    val cornerNormal: Shape,
    val cornerBig: Shape,
    val cornerExtra: Shape,
)

val shapes = RDShape(
    padding4 = 4.dp,
    padding8 = 8.dp,
    padding16 = 16.dp,
    padding24 = 24.dp,
    padding32 = 32.dp,
    padding54 = 54.dp,
    padding64 = 64.dp,
    padding72 = 72.dp,
    cornerNone = RoundedCornerShape(0.dp),
    cornerSmall = RoundedCornerShape(4.dp),
    cornerNormal = RoundedCornerShape(8.dp),
    cornerBig = RoundedCornerShape(16.dp),
    cornerExtra = RoundedCornerShape(24.dp),
)