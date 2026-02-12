package eu.indiewalkabout.analytics.data.di

import eu.indiewalkabout.analytics.data.RoomAnalyticsRepository
import eu.indiewalkabout.analytics.domain.AnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}