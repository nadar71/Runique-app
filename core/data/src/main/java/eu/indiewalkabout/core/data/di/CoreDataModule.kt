package eu.indiewalkabout.core.data.di

import eu.indiewalkabout.core.data.networking.HttpClientFactory
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}