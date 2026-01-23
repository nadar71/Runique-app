package eu.indiewalkabout.auth.presentation.register

import eu.indiewalkabout.core.presentation.ui.UiText


sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}