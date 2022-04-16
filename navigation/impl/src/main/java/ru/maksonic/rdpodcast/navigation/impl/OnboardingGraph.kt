package ru.maksonic.rdpodcast.navigation.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import ru.maksonic.rdpodcast.feature.onboarding.OnboardingScreen
import ru.maksonic.rdpodcast.navigation.api.AuthRoute
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.navigation.api.OnboardingRoute
import ru.maksonic.rdpodcast.navigation.api.safeNavigate

/**
 * @Author: maksonic on 09.03.2022
 */
@OptIn(ExperimentalAnimationApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
fun NavGraphBuilder.onboardingGraph(
    navController: NavHostController,
) {
    navigation(
        route = OnboardingRoute.route,
        startDestination = OnboardingRoute.OnboardingScreen.route
    ) {
        composable(OnboardingRoute.OnboardingScreen.route) {
            OnboardingScreen(
                skipOnboarding = {
                    navController.safeNavigate(route = MainRoute.MainScreen.route)
                },
                showAuthBottomSheet = {
                    navController.safeNavigate(AuthRoute.AuthBottomSheet.route)
                },
            )
        }
    }
}


