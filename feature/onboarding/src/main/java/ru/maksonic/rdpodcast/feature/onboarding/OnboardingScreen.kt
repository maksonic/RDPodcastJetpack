package ru.maksonic.rdpodcast.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import ru.maksonic.rdpodcast.domain.onboarding.Onboarding
import ru.maksonic.rdpodcast.shared.ui.component.PrimaryButton
import ru.maksonic.rdpodcast.shared.ui.component.SkipButton
import ru.maksonic.rdpodcast.shared.ui.theme.RDPodcastTheme
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 04.03.2022
 */

@Preview(name = "OnboardingScreen", showSystemUi = true)
@Composable
private fun PreviewOnboardingScreen() {
    RDPodcastTheme() {
        Surface() {
            OnboardingScreen(skipOnboarding = {}, showAuthBottomSheet = {})
        }
    }
}



@OptIn(ExperimentalPagerApi::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    skipOnboarding: () -> Unit,
    showAuthBottomSheet: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)

    RDPodcastTheme {

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            scaffoldState = scaffoldState,
            backgroundColor = RDTheme.color.background,
            topBar = {
                TopAppBar(
                    title = {},
                    backgroundColor = RDTheme.color.background,
                    elevation = 0.dp,
                    actions = { SkipButton(action = skipOnboarding) }
                )
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CompositionLocalProvider(LocalOverScrollConfiguration provides null) {

                    HorizontalPager(
                        count = viewModel.onboardingList.size,
                        state = pagerState,
                        modifier = Modifier.weight(1.0f)
                    ) { page ->
                        OnboardingItem(page, onboarding = viewModel.onboardingList)
                    }
                }
                Spacer(modifier = Modifier.size(RDTheme.shape.padding16))
                DotsIndicator(
                    totalDots = 4,
                    selectedIndex = pagerState.currentPage,
                    selectedColor = RDTheme.color.primary,
                    unSelectedColor = RDTheme.color.divider
                )
                Spacer(modifier = Modifier.size(RDTheme.shape.padding16))
                PrimaryButton(
                    action = { showAuthBottomSheet.invoke() },
                    title = R.string.btn_title_create_account
                )
                Spacer(modifier = Modifier.size(RDTheme.shape.padding16))
            }
        }
    }
}


@Composable
private fun OnboardingItem(
    page: Int,
    onboarding: List<Onboarding>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Image(
                modifier = modifier
                    .fillMaxSize()
                    .padding(
                        top = RDTheme.shape.padding54,
                        start = RDTheme.shape.padding16,
                        end = RDTheme.shape.padding16
                    ),
                painter = painterResource(id = onboarding[page].image),
                contentDescription = stringResource(id = R.string.cd_img_onboarding)
            )
        }
        Spacer(modifier = Modifier.size(RDTheme.shape.padding16))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(
                start = RDTheme.shape.padding16,
                end = RDTheme.shape.padding16
            )
        ) {
            Text(
                text = onboarding[page].title,
                style = RDTheme.typography.display,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(RDTheme.shape.padding16))
            Text(
                text = onboarding[page].description,
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(RDTheme.shape.padding16))

        }
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}