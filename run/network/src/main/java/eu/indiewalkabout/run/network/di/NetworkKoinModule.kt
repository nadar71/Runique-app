package eu.indiewalkabout.run.network.di

import eu.indiewalkabout.core.domain.run.RemoteRunDataSource
import eu.indiewalkabout.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}