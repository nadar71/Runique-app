package eu.indiewalkabout.auth.data

import android.util.Patterns
import eu.indiewalkabout.auth.domain.PatternValidator

object EmailPatternValidator: PatternValidator {

    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}