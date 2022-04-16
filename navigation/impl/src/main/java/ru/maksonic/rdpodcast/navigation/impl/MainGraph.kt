package ru.maksonic.rdpodcast.navigation.impl

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navigation
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.screen.main.MainScreen

/**
 * @Author: maksonic on 09.03.2022
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainGraph(
    navController: NavHostController
) {
    navigation(
        route = MainRoute.route,
        startDestination = MainRoute.MainScreen.route
    ) {
        composable(MainRoute.MainScreen.route) {
            MainScreen()
        }
    }
}
