package dev.xxxxx.petrolooze

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetroloozeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /* no-op */
    }
}
