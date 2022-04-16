package ru.maksonic.rdpodcast.navigation.api

/**
 * @Author: maksonic on 06.03.2022
 */
object AuthRoute : Route("auth") {
    object AuthBottomSheet : Route("auth.bottom_sheet")

    object PrivacyPolicy : Route("auth.privacy") {
        const val args = "/{passed_privacy_or_terms_key}"
        fun buildArgsRoute(id: String) = "${this.route}/${id}"
    }
}