package ru.maksonic.rdpodcast.screen.main.component

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 31.03.2022
 */
@Composable
internal fun MainBottomNavigationBar(navController: NavController) {
    val items = listOf(
        MainRoute.HomeScreen,
        MainRoute.CategoriesScreen,
        MainRoute.CollectionsScreen
    )

    BottomAppBar(
        backgroundColor = RDTheme.color.surface
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainRoute.HomeScreen.route
        for (screen in items) {
            val label = stringResource(screen.labelId)
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(
                            id = if (currentRoute == screen.route) {
                                screen.selectedIcon
                            } else {
                                screen.unselectedIcon
                            }
                        ), label
                    )
                },
                label = { Text(label) },
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(checkNotNull(navController.graph.startDestinationRoute)) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}