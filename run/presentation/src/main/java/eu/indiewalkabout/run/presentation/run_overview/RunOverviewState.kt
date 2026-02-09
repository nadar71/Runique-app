package eu.indiewalkabout.run.presentation.run_overview

import eu.indiewalkabout.run.presentation.run_overview.model.RunUi


data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
