package ru.maksonic.rdpodcast.navigation.api

import androidx.navigation.NavHostController

/**
 * @Author: maksonic on 09.03.2022
 */
fun NavHostController.safeNavigate(route: String) {
    if (this.currentDestination?.route != route)
        this.navigate(route)
    else this.popBackStack()
}

