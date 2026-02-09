package eu.indiewalkabout.core.data.di

import eu.indiewalkabout.core.data.auth.EncryptedSessionStorage
import eu.indiewalkabout.core.data.networking.HttpClientFactory
import eu.indiewalkabout.core.data.run.OfflineFirstRunRepository
import eu.indiewalkabout.core.domain.SessionStorage
import eu.indiewalkabout.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}
