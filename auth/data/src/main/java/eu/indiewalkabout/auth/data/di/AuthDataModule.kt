package eu.indiewalkabout.auth.data.di


import eu.indiewalkabout.auth.data.EmailPatternValidator
import eu.indiewalkabout.auth.domain.PatternValidator
import eu.indiewalkabout.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}