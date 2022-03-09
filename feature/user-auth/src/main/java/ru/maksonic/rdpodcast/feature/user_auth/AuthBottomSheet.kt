package ru.maksonic.rdpodcast.feature.user_auth

import android.util.Log
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ru.maksonic.rdpodcast.shared.ui.component.BottomSheetIndicator
import ru.maksonic.rdpodcast.shared.ui.theme.RDPodcastTheme
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 06.03.2022
 */
@Composable
fun AuthBottomSheet(
    showPrivacy: () -> Unit
) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
           ) {
            BottomSheetIndicator()

            AuthItem(
                icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_google,
                title = stringResource(id = R.string.btn_title_auth_google),
                action = {}

            )
            Divider(
                modifier = Modifier
                    .padding(start = RDTheme.shape.padding16, end = RDTheme.shape.padding16),
                color = RDTheme.color.divider
            )
            AuthItem(
                icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_phone,
                title = stringResource(id = R.string.btn_title_auth_phone),
                action = {}

            )
            Divider(
                modifier = Modifier
                    .padding(start = RDTheme.shape.padding16, end = RDTheme.shape.padding16),
                color = RDTheme.color.divider
            )
            AuthItem(
                icon = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_login,
                title = stringResource(id = R.string.btn_title_log_in),
                action = {}
            )

            AnnotatedClickableText(showPrivacy)

            Spacer(modifier = Modifier.height(32.dp))
        }
}

@Composable
fun AuthItem(modifier: Modifier = Modifier, icon: Int, title: String, action: () -> Unit) {
    RDPodcastTheme() {
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
            Icon(painter = painterResource(id = icon), contentDescription = null, modifier.padding(start = RDTheme.shape.padding16))
            Spacer(modifier.padding(start = RDTheme.shape.padding16))
            Text(text = title, style = RDTheme.typography.body)
        }
    }
}


@Composable
fun AnnotatedClickableText(showPrivacy: () -> Unit) {
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(tag = "URL",
            annotation = "https://developer.android.com")
        withStyle(style = SpanStyle(color = Color.Blue,
            fontWeight = FontWeight.Bold)
        ) {
            append("here")
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(tag = "URL", start = offset,
                end = offset)
                .firstOrNull()?.let { annotation ->
                    showPrivacy.invoke()
                    // If yes, we log its value
                    Log.d("Clicked URL", annotation.item)
                }
        }
    )
}


/*
@Composable
fun Modifier.customClickable(
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication = rememberRipple(bounded = false),
    onClick: Unit
) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customClickable"
        properties["interactionSource"] = interactionSource
        properties["indication"] = indication
        properties["onClick"] = onClick
    }
)*/
