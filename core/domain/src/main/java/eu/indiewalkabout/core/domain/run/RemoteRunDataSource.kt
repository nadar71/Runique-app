package eu.indiewalkabout.core.domain.run

import eu.indiewalkabout.core.domain.util.DataError
import eu.indiewalkabout.core.domain.util.EmptyResult
import eu.indiewalkabout.core.domain.util.Result



interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}