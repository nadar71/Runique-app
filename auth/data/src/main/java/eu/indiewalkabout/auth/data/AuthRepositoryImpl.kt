@file:OptIn(InternalSerializationApi::class)

package eu.indiewalkabout.auth.data

import eu.indiewalkabout.auth.domain.AuthRepository
import eu.indiewalkabout.core.data.networking.post
import eu.indiewalkabout.core.domain.AuthInfo
import eu.indiewalkabout.core.domain.SessionStorage
import eu.indiewalkabout.core.domain.util.DataError
import eu.indiewalkabout.core.domain.util.EmptyResult
import eu.indiewalkabout.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient
import kotlinx.serialization.InternalSerializationApi
import eu.indiewalkabout.core.domain.util.Result

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }

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
