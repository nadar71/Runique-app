package eu.indiewalkabout.run.presentation.di

import eu.indiewalkabout.run.presentation.active_run.ActiveRunViewModel
import eu.indiewalkabout.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}