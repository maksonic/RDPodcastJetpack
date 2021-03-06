package ru.maksonic.rdpodcast.shared.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import ru.maksonic.rdpodcast.shared.ui.R
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun SmallAppTopBar(
    title: String,
    iconId: Int = R.drawable.ic_round_action_back,
    elevation: Dp = RDTheme.elevation.dp1,
    navIconAction: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = RDTheme.color.background,
        elevation = elevation,
        navigationIcon = {
            IconButton(onClick = navIconAction) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null
                )
            }
        },
    )
}