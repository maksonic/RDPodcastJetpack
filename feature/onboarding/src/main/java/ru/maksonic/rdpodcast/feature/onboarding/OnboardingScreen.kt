package ru.maksonic.rdpodcast.feature.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.maksonic.rdpodcast.domain.onboarding.Onboarding
import ru.maksonic.rdpodcast.shared.ui.component.CloseIconButton
import ru.maksonic.rdpodcast.shared.ui.component.DotsIndicator
import ru.maksonic.rdpodcast.shared.ui.component.PrimaryButton
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 04.03.2022
 */
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(skipOnboarding = {}, showAuthBottomSheet = {})
}

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    skipOnboarding: () -> Unit,
    showAuthBottomSheet: () -> Unit,
) {
    OnboardingUiScreen(skipOnboarding, showAuthBottomSheet)
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun OnboardingUiScreen(
    skipOnboarding: () -> Unit,
    showAuthBottomSheet: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel(),

    ) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    SideEffect {
        scope.launch {
            viewModel.effects.collect {
                when (it) {
                    is OnboardingFeature.Effect.SkipOnboarding -> {
                        skipOnboarding()
                    }
                    is OnboardingFeature.Effect.ShowAuthBottomSheet -> {
                        showAuthBottomSheet()
                    }
                }
            }
        }
    }

    Scaffold(
        backgroundColor = RDTheme.color.background,
        topBar = {
            TopAppBar(
                title = {},
                backgroundColor = RDTheme.color.background,
                elevation = 0.dp,
                actions = { CloseIconButton({ viewModel.skipOnboarding() })}
            )},
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(it)
        ) {
            CompositionLocalProvider(LocalOverScrollConfiguration provides null) {

                HorizontalPager(
                    count = state.onboardingList.size,
                    state = pagerState,
                    modifier = Modifier.weight(1.0f)
                ) { page ->
                    OnboardingItem(page, onboarding = state.onboardingList)
                }
            }
            Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
            DotsIndicator(
                totalDots = 4,
                selectedIndex = pagerState.currentPage,
                selectedColor = RDTheme.color.primary,
                unSelectedColor = RDTheme.color.divider
            )
            Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
            PrimaryButton(
                action = { viewModel.showAuthBottomSheet() },
                title = R.string.btn_title_create_account
            )
            Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
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
            AsyncImage(
                model = onboarding[page].image,
                modifier = modifier
                    .fillMaxSize()
                    .padding(
                        top = RDTheme.padding.dp54,
                        start = RDTheme.padding.dp16,
                        end = RDTheme.padding.dp16
                    ),
                contentDescription = stringResource(id = R.string.cd_img_onboarding))
        }
        Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(
                start = RDTheme.padding.dp16,
                end = RDTheme.padding.dp16
            )
        ) {
            Text(
                text = onboarding[page].title,
                style = RDTheme.typography.display,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
            Text(
                text = onboarding[page].description,
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(RDTheme.padding.dp16))
        }
    }
}