package eu.indiewalkabout.runique

import android.app.Application
import eu.indiewalkabout.auth.data.di.authDataModule
import eu.indiewalkabout.auth.presentation.di.authViewModelModule
import eu.indiewalkabout.core.data.di.coreDataModule
import eu.indiewalkabout.run.presentation.run_overview.di.runViewModelModule
import eu.indiewalkabout.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runViewModelModule
            )
        }
    }
}
