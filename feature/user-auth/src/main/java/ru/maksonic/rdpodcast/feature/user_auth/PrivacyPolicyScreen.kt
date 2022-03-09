package ru.maksonic.rdpodcast.feature.user_auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.maksonic.rdpodcast.shared.ui.component.SmallAppTopBar

/**
 * @Author: maksonic on 09.03.2022
 */
@Composable
fun PrivacyPolicyScreen(
    toolBarBackPressed: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().clickable {  },
        topBar = {
            SmallAppTopBar(
                title = stringResource(id = R.string.scr_title_privacy_policy),
                navIconAction = toolBarBackPressed
            )
        }) {

    }
}