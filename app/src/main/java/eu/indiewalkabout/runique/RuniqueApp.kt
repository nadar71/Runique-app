package eu.indiewalkabout.runique

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.plcoding.run.data.di.runDataModule
import eu.indiewalkabout.run.network.di.networkModule
import eu.indiewalkabout.run.location.di.locationModule
import eu.indiewalkabout.run.presentation.di.runPresentationModule
import eu.indiewalkabout.auth.data.di.authDataModule
import eu.indiewalkabout.auth.presentation.di.authViewModelModule
import eu.indiewalkabout.core.data.di.coreDataModule
import eu.indiewalkabout.core.database.di.databaseModule
import eu.indiewalkabout.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}
