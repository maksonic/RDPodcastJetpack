package ru.maksonic.rdpodcast.feature.user_auth.privacy

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ru.maksonic.rdpodcast.shared.ui.component.SmallAppTopBar
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 09.03.2022
 */
@Preview
@Composable
fun PrivacyPolicyScreenPreview() {
    PrivacyPolicyScreen(toolBarBackPressed = {})
}
@Composable
fun PrivacyPolicyScreen(
    toolBarBackPressed: () -> Unit,
) {
    PrivacyPolicyUiScreen(toolBarBackPressed)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun PrivacyPolicyUiScreen(
    toolBarBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PrivacyViewModel = hiltViewModel()
) {
    val uiScreenState by viewModel.state

    Scaffold(
        backgroundColor = RDTheme.color.background,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = {
            SmallAppTopBar(
                title = uiScreenState.title,
                navIconAction = toolBarBackPressed
            )
        }) {

        LazyColumn() {
            item {
                Text(
                    text = uiScreenState.content,
                    style = RDTheme.typography.body,
                    modifier = modifier
                        .padding(
                            start = RDTheme.padding.dp16,
                            end = RDTheme.padding.dp16,
                            top = RDTheme.padding.dp16
                        )
                )
            }
        }
    }
}