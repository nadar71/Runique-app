@file:OptIn(InternalSerializationApi::class)

package eu.indiewalkabout.core.data.auth

import eu.indiewalkabout.core.domain.AuthInfo
import kotlinx.serialization.InternalSerializationApi

fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId
    )
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId
    )
}