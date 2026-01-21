package eu.indiewalkabout.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}