package ru.maksonic.rdpodcast.navigation.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import ru.maksonic.rdpodcast.feature.user_auth.auth_bottom_sheet.AuthBottomSheet
import ru.maksonic.rdpodcast.feature.user_auth.privacy.PrivacyPolicyScreen
import ru.maksonic.rdpodcast.navigation.api.AuthRoute
import ru.maksonic.rdpodcast.navigation.api.safeNavigate

/**
 * @Author: maksonic on 09.03.2022
 */

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    androidx.compose.material.ExperimentalMaterialApi::class,
    androidx.compose.animation.ExperimentalAnimationApi::class
)
fun NavGraphBuilder.authGraph(
    navController: NavHostController,
) {
    navigation(
        route = AuthRoute.route,
        startDestination = AuthRoute.AuthBottomSheet.route
    ) {
        bottomSheet(
            route = AuthRoute.AuthBottomSheet.route,
        ) {
            AuthBottomSheet(
                showPrivacy = { privacy ->
                    navController.safeNavigate(AuthRoute.PrivacyPolicy.buildArgsRoute(privacy))
                },
                showTermsOfUse = { terms ->
                    navController.safeNavigate(AuthRoute.PrivacyPolicy.buildArgsRoute(terms))
                }
            )
        }
        composable(route = AuthRoute.PrivacyPolicy.route.plus(AuthRoute.PrivacyPolicy.args))
        {
            PrivacyPolicyScreen(
                toolBarBackPressed = { navController.navigateUp() }
            )
        }
    }
}