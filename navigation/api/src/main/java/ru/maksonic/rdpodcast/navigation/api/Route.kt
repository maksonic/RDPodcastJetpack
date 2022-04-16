package ru.maksonic.rdpodcast.navigation.api

import androidx.annotation.StringRes

/**
 * @Author: maksonic on 04.03.2022
 */
sealed class Route(val route: String) {

    interface BottomNavRoute {
        val selectedIcon: Int
        val unselectedIcon: Int

        @get:StringRes
        val labelId: Int
    }
}