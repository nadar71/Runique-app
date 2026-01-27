package eu.indiewalkabout.run.location

import android.location.Location
import eu.indiewalkabout.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = eu.indiewalkabout.core.domain.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}