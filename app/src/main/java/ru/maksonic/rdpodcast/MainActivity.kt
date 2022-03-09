package ru.maksonic.rdpodcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.rdpodcast.navigation.api.OnboardingRoute
import ru.maksonic.rdpodcast.navigation.impl.authGraph
import ru.maksonic.rdpodcast.navigation.impl.mainGraph
import ru.maksonic.rdpodcast.navigation.impl.onboardingGraph
import ru.maksonic.rdpodcast.shared.ui.theme.RDPodcastTheme
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseDarkPalette
import ru.maksonic.rdpodcast.shared.ui.theme.color.baseLightPalette

/**
 * @Author: maksonic on 04.03.2022
 */
@OptIn(ExperimentalMaterialNavigationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val modalBottomSheetState =
                rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val navController = rememberNavController(bottomSheetNavigator)

            RDPodcastTheme {
                ModalBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    sheetShape = RDTheme.shape.cornerExtra
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = OnboardingRoute.route
                    ) {
                        onboardingGraph(navController)
                        authGraph(navController)
                        mainGraph(navController)
                    }
                }
            }
        }
    }
}



