package ru.maksonic.rdpodcast.shared.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.maksonic.rdpodcast.shared.ui.R
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 05.03.2022
 */
@Composable
fun CloseIconButton(action: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = action) {
        Icon(
            painter = painterResource(id = R.drawable.ic_round_action_skip),
            contentDescription = stringResource(id = R.string.cd_btn_skip),
            tint = RDTheme.color.primary,
            modifier = modifier.size(RDTheme.componentSize.btnNav)
        )
    }
}