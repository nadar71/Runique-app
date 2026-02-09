package eu.indiewalkabout.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}