package eu.indiewalkabout.run.presentation.active_run

import eu.indiewalkabout.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}