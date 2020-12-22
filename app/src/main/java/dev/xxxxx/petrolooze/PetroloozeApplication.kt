package dev.xxxxx.petrolooze

import android.app.Application
import dev.xxxxx.feature1.di.stationListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PetroloozeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PetroloozeApplication)
            androidFileProperties()
            modules(
                stationListModule
            )
        }

    }

}
