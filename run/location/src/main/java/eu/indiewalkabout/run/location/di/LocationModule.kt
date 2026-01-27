package eu.indiewalkabout.run.location.di

import eu.indiewalkabout.run.domain.LocationObserver
import eu.indiewalkabout.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}