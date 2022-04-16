package ru.maksonic.rdpodcast.screen.main.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.screen.categories.CategoriesScreen
import ru.maksonic.rdpodcast.screen.collection.CollectionScreen
import ru.maksonic.rdpodcast.screen.home.HomeScreen

/**
 * @Author: maksonic on 31.03.2022
 */
@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.mainBottomGraph(
    navController: NavHostController
) {

    composable(MainRoute.HomeScreen.route) {
        HomeScreen()
    }
    composable(MainRoute.CategoriesScreen.route) {
        CategoriesScreen()
    }
    composable(MainRoute.CollectionsScreen.route) {
        CollectionScreen()
    }
}

