package ru.maksonic.rdpodcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.rdpodcast.core.settings.AppTheme
import ru.maksonic.rdpodcast.core.settings.ThemeSetting
import ru.maksonic.rdpodcast.navigation.api.OnboardingRoute
import ru.maksonic.rdpodcast.navigation.impl.authGraph
import ru.maksonic.rdpodcast.navigation.impl.mainGraph
import ru.maksonic.rdpodcast.navigation.impl.onboardingGraph
import ru.maksonic.rdpodcast.shared.ui.theme.HighContrastTheme
import ru.maksonic.rdpodcast.shared.ui.theme.InitSystemComponentsColor
import ru.maksonic.rdpodcast.shared.ui.theme.MainTheme
import ru.maksonic.rdpodcast.shared.ui.theme.RDTheme
import javax.inject.Inject

/**
 * @Author: maksonic on 04.03.2022
 */
@OptIn(ExperimentalMaterialNavigationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var themeSetting: ThemeSetting

    @OptIn(
        ExperimentalMaterialApi::class,
        androidx.compose.animation.ExperimentalAnimationApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberAnimatedNavController()
            navController.navigatorProvider.plusAssign(bottomSheetNavigator)
            val systemTheme = isSystemInDarkTheme()
            val appTheme = themeSetting.themeStream.collectAsState()

            val rdTheme: @Composable (content: @Composable () -> Unit
            ) -> Unit = when (appTheme.value) {
                AppTheme.SYSTEM -> { content -> MainTheme(systemTheme, content) }
                AppTheme.LIGHT -> { content -> MainTheme(false, content) }
                AppTheme.DARK -> { content -> MainTheme(true, content = content) }
                AppTheme.HIGH_CONTRAST -> { content -> HighContrastTheme(systemTheme, content) }
            }

            rdTheme.invoke() {
                val actualBackgroundColor = RDTheme.color.background
                InitSystemComponentsColor(systemTheme, appTheme, actualBackgroundColor)

                ModalBottomSheetLayout(
                    bottomSheetNavigator = bottomSheetNavigator,
                    sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    sheetBackgroundColor = RDTheme.color.surface,

                ) {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = OnboardingRoute.route,
                        enterTransition = { fadeIn() },
                        exitTransition = { fadeOut() },
                        popEnterTransition = { fadeIn() },
                        popExitTransition = { fadeOut() },
                        modifier = Modifier.systemBarsPadding()
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



