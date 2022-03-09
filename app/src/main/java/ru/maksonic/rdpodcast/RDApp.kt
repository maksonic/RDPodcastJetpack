package ru.maksonic.rdpodcast

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @Author: maksonic on 05.03.2022
 */
@HiltAndroidApp
class RDApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}