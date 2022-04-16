package ru.maksonic.rdpodcast.screen.main

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ru.maksonic.rdpodcast.navigation.api.MainRoute
import ru.maksonic.rdpodcast.screen.main.component.MainBottomNavigationBar
import ru.maksonic.rdpodcast.screen.main.component.MainTopAppBar
import ru.maksonic.rdpodcast.screen.main.component.mainBottomGraph
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme

/**
 * @Author: maksonic on 04.03.2022
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    MainUiScreen()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainUiScreen() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopAppBar(showSettings = {}) },
        bottomBar = { MainBottomNavigationBar(navController) },
        backgroundColor = RDTheme.color.background
    ) {
        AnimatedNavHost(navController, startDestination = MainRoute.HomeScreen.route) {
            mainBottomGraph(navController)
        }
    }
}