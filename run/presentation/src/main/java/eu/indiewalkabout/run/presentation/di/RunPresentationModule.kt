package eu.indiewalkabout.run.presentation.di

import eu.indiewalkabout.run.domain.RunningTracker
import eu.indiewalkabout.run.presentation.active_run.ActiveRunViewModel
import eu.indiewalkabout.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}