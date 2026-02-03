package eu.indiewalkabout.run.presentation.run_overview.mapper

import eu.indiewalkabout.core.domain.run.Run
import eu.indiewalkabout.run.presentation.run_overview.model.RunUi
import eu.indiewalkabout.core.presentation.ui.formatted
import eu.indiewalkabout.core.presentation.ui.toFormattedKm
import eu.indiewalkabout.core.presentation.ui.toFormattedKmh
import eu.indiewalkabout.core.presentation.ui.toFormattedMeters
import eu.indiewalkabout.core.presentation.ui.toFormattedPace
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}