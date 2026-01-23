package eu.indiewalkabout.auth.domain

import eu.indiewalkabout.core.domain.util.DataError
import eu.indiewalkabout.core.domain.util.EmptyResult


interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}