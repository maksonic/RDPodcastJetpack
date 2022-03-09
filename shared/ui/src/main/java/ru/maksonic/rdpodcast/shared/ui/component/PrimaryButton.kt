package ru.maksonic.rdpodcast.shared.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.maksonic.rdpodcast.core.*
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 05.03.2022
 */
@Composable
fun PrimaryButton(action: () -> Unit, title: Int, modifier: Modifier = Modifier) {
    Button(
        onClick = action,
        colors = ButtonDefaults.buttonColors(RDTheme.color.primary),
        shape = RDTheme.shape.cornerNormal,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(RDTheme.componentSize.btnPrimaryHeight)
            .padding(
                start = RDTheme.shape.padding16,
                end = RDTheme.shape.padding16
            )

    ) {
        Text(text = stringResource(id = title), color = RDTheme.color.onPrimary, style = RDTheme.typography.body)
    }
}
