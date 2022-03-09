package ru.maksonic.rdpodcast.screen.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.screen.categories.CategoriesScreen
import ru.maksonic.rdpodcast.screen.collection.CollectionScreen
import ru.maksonic.rdpodcast.screen.home.HomeScreen

/**
 * @Author: maksonic on 04.03.2022
 */
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopAppBar() },
        bottomBar = { MainBottomNavigationBar(navController) }
    ) {
        NavHost(navController, startDestination = MainRoute.HomeScreen.route) {
            mainBottomGraph(navController)
        }
    }
}

@Composable
private fun MainTopAppBar() {

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = ru.maksonic.rdpodcast.shared.ui.R.drawable.ic_round_action_back),
                    contentDescription = stringResource(id = R.string.ssds),
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    stringResource(id = R.string.ssds),
                    style = MaterialTheme.typography.body1
                )
            }
        },
        actions = { }
    )
}

@Composable
private fun MainBottomNavigationBar(navController: NavController) {
    val items = listOf(
        MainRoute.HomeScreen,
        MainRoute.CategoriesScreen,
        MainRoute.CollectionsScreen
    )

    BottomAppBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainRoute.HomeScreen.route
        for (screen in items) {
            val label = stringResource(screen.labelId)
            BottomNavigationItem(
                icon = { Icon(painterResource(id = screen.icon), label) },
                label = { Text(label) },
                alwaysShowLabel = false,
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

fun NavGraphBuilder.mainBottomGraph(
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


