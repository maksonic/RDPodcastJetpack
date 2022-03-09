package ru.maksonic.rdpodcast.navigation.api

/**
 * @Author: maksonic on 06.03.2022
 */
object MainRoute : Route("main") {
    object MainScreen : Route("main.screen")

    object HomeScreen : Route("main.home"), BottomNavRoute {
        override val icon: Int = R.drawable.ic_bottom_nav_home
        override val labelId: Int = R.string.scr_home
    }

    object CategoriesScreen : Route("main.categories"), BottomNavRoute {
        override val icon: Int = R.drawable.ic_bottom_nav_categories
        override val labelId: Int = R.string.scr_categories
    }

    object CollectionsScreen : Route("main.collections"), BottomNavRoute {
        override val icon: Int = R.drawable.ic_bottom_nav_collections
        override val labelId: Int = R.string.scr_collections
    }
}