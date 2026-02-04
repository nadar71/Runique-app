package eu.indiewalkabout.run.network

import eu.indiewalkabout.core.domain.run.RemoteRunDataSource
import eu.indiewalkabout.core.data.networking.constructRoute
import eu.indiewalkabout.core.data.networking.get
import eu.indiewalkabout.core.data.networking.safeCall
import eu.indiewalkabout.core.data.networking.delete
import eu.indiewalkabout.core.domain.run.Run
import eu.indiewalkabout.core.domain.util.DataError
import eu.indiewalkabout.core.domain.util.EmptyResult
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import eu.indiewalkabout.core.domain.util.Result
import eu.indiewalkabout.core.domain.util.map
import io.ktor.client.HttpClient


class KtorRemoteRunDataSource(
    private val httpClient: HttpClient
): RemoteRunDataSource {

    override suspend fun getRuns(): Result<List<Run>, DataError.Network> {
        return httpClient.get<List<RunDto>>(
            route = "/runs",
        ).map { runDtos ->
            runDtos.map { it.toRun() }
        }
    }

    override suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network> {
        val createRunRequestJson = Json.encodeToString(run.toCreateRunRequest())
        val result = safeCall<RunDto> {
            httpClient.submitFormWithBinaryData(
                url = constructRoute("/run"),
                formData = formData {
                    append("MAP_PICTURE", mapPicture, Headers.build {
                        append(HttpHeaders.ContentType, "image/jpeg")
                        append(HttpHeaders.ContentDisposition, "filename=mappicture.jpg")
                    })
                    append("RUN_DATA", createRunRequestJson, Headers.build {
                        append(HttpHeaders.ContentType, "text/plain")
                        append(HttpHeaders.ContentDisposition, "form-data; name=\"RUN_DATA\"")
                    })
                }
            ) {
                method = HttpMethod.Post
            }
        }
        return result.map {
            it.toRun()
        }
    }

    override suspend fun deleteRun(id: String): EmptyResult<DataError.Network> {
        return httpClient.delete(
            route = "/run",
            queryParameters = mapOf(
                "id" to id
            )
        )
    }
}