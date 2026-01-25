package eu.indiewalkabout.auth.presentation.login

import eu.indiewalkabout.core.presentation.ui.UiText


sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}