package ru.maksonic.rdpodcast.screen.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.maksonic.rdpodcast.screen.main.R
import ru.maksonic.rdpodcast.shared.ui.component.ActionIconButton
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 31.03.2022
 */
@Composable
internal fun MainTopAppBar(
    showSettings: () -> Unit
) {
    TopAppBar(
        title = {},
        backgroundColor = RDTheme.color.background,
        elevation = 0.dp,
        navigationIcon = {
            ActionIconButton(onClick = showSettings) {
                Icon(
                    painter = painterResource(id = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_user_profile),
                    contentDescription = null,
                    tint = RDTheme.color.primaryText
                )
            }
        },
        actions = {
            ActionIconButton(onClick = showSettings) {
                Icon(
                    painter = painterResource(id = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_round_search),
                    contentDescription = null,
                    tint = RDTheme.color.primaryText
                )
            }
            ActionIconButton(onClick = showSettings) {
                Icon(
                    painter = painterResource(id = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_settings),
                    contentDescription = null,
                    tint = RDTheme.color.primaryText
                )
            }
        }
    )
}