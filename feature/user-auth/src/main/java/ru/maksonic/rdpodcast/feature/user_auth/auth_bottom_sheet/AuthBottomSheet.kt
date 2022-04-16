package ru.maksonic.rdpodcast.feature.user_auth.auth_bottom_sheet

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ru.maksonic.rdpodcast.feature.user_auth.R
import ru.maksonic.rdpodcast.feature.user_auth.components.AnnotatedClickableText
import ru.maksonic.rdpodcast.feature.user_auth.components.AuthItem
import ru.maksonic.rdpodcast.shared.ui.component.BottomSheetIndicator
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 06.03.2022
 */

@Preview
@Composable
fun AuthBottomSheetPreview() {
    AuthBottomSheet(showPrivacy = {}, showTermsOfUse = {})
}

@Composable
fun AuthBottomSheet(
    showPrivacy: (String) -> Unit,
    showTermsOfUse: (String) -> Unit,
) {
    AuthBottomSheetUi(showPrivacy, showTermsOfUse)
}

@Composable
private fun AuthBottomSheetUi(
    showPrivacy: (String) -> Unit,
    showTermsOfUse: (String) -> Unit,
    viewModel: AuthBottomSheetViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BottomSheetIndicator()

        AuthItem(
            icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_google,
            title = stringResource(id = R.string.btn_title_auth_google),
            action = {}
        )

        AuthItem(
            icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_phone,
            title = stringResource(id = R.string.btn_title_auth_phone),
            action = {}
        )

        AuthItem(
            icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_login,
            title = stringResource(id = R.string.btn_title_log_in),
            action = {}
        )
        Spacer(modifier = Modifier.height(RDTheme.padding.dp16))

        AnnotatedClickableText(
            showPrivacy = showPrivacy,
            showTermsOfUse = showTermsOfUse,
            termsOfUseKey = viewModel.termsKey,
            privacyKey = viewModel.privacyKey
        )

        Spacer(modifier = Modifier.height(RDTheme.padding.dp32))
    }
}

