package ru.maksonic.rdpodcast.feature.user_auth.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @author maksonic on 16.04.2022
 */
@Composable
internal fun AuthItem(modifier: Modifier = Modifier, icon: Int, title: String, action: () -> Unit) {
    Column() {
        Row(
            modifier
                .fillMaxWidth()
                .height(RDTheme.componentSize.btnPrimaryHeight)
                .clickable(
                    onClick = action,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = true)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier.padding(start = RDTheme.padding.dp16)
            )
            Spacer(modifier.padding(start = RDTheme.padding.dp16))
            Text(text = title, style = RDTheme.typography.body)
        }

        Divider(
            modifier = Modifier
                .padding(start = RDTheme.padding.dp16, end = RDTheme.padding.dp16),
            color = RDTheme.color.divider
        )
    }
}