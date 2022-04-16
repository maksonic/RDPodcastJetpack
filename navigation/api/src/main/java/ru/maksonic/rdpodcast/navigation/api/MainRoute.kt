package ru.maksonic.rdpodcast.navigation.api

/**
 * @Author: maksonic on 06.03.2022
 */
object MainRoute : Route("main") {
    object MainScreen : Route("main.screen")

    object HomeScreen : Route("main.home"), BottomNavRoute {
        override val selectedIcon: Int = R.drawable.id_rd_filled
        override val unselectedIcon: Int = R.drawable.ic_rd_outlined
        override val labelId: Int = R.string.scr_home
    }

    object CategoriesScreen : Route("main.categories"), BottomNavRoute {
        override val selectedIcon: Int = R.drawable.ic_category_filled
        override val unselectedIcon: Int = R.drawable.ic_category_outlined
        override val labelId: Int = R.string.scr_categories
    }

    object CollectionsScreen : Route("main.collections"), BottomNavRoute {
        override val selectedIcon: Int = R.drawable.ic_collections_filled
        override val unselectedIcon: Int = R.drawable.ic_collections_outlined
        override val labelId: Int = R.string.scr_collections
    }
}