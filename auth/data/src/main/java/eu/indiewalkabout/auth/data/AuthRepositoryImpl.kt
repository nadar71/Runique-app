package eu.indiewalkabout.auth.data

import eu.indiewalkabout.auth.domain.AuthRepository
import eu.indiewalkabout.core.data.networking.post
import eu.indiewalkabout.core.domain.util.DataError
import eu.indiewalkabout.core.domain.util.EmptyResult
import io.ktor.client.HttpClient
import kotlinx.serialization.InternalSerializationApi

@OptIn(InternalSerializationApi::class)
class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}