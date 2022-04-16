package ru.maksonic.rdpodcast.domain.privacy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @Author: maksonic on 09.03.2022
 */
@Parcelize
data class PrivacyPolicy(
    val title: String,
    val content: String,
) : Parcelable
