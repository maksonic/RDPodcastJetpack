package ru.maksonic.rdpodcast.navigation.impl

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import ru.maksonic.rdpodcast.feature.user_auth.AuthBottomSheet
import ru.maksonic.rdpodcast.feature.user_auth.PrivacyPolicyScreen
import ru.maksonic.rdpodcast.navigation.api.AuthRoute
import ru.maksonic.rdpodcast.navigation.api.safeNavigate

/**
 * @Author: maksonic on 09.03.2022
 */
@OptIn(ExperimentalMaterialNavigationApi::class)
fun NavGraphBuilder.authGraph(navController: NavHostController) {

     navigation(
        route = AuthRoute.route,
        startDestination = AuthRoute.AuthBottomSheet.route
    ) {
        bottomSheet(route = AuthRoute.AuthBottomSheet.route) {
            AuthBottomSheet(
                showPrivacy = { navController.safeNavigate(route = AuthRoute.PrivacyPolicy.route) }
            )
        }
        bottomSheet(route = AuthRoute.PrivacyPolicy.route) {
            PrivacyPolicyScreen(toolBarBackPressed = { navController.navigateUp() })
        }
    }
}