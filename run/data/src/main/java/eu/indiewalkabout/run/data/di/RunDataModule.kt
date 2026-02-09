package com.plcoding.run.data.di

import eu.indiewalkabout.core.domain.run.SyncRunScheduler
import eu.indiewalkabout.run.data.CreateRunWorker
import eu.indiewalkabout.run.data.DeleteRunWorker
import eu.indiewalkabout.run.data.FetchRunsWorker
import eu.indiewalkabout.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}