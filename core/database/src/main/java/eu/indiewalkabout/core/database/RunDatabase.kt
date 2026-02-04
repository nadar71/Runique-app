package eu.indiewalkabout.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.indiewalkabout.core.database.dao.RunDao
import eu.indiewalkabout.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RunDatabase: RoomDatabase() {

    abstract val runDao: RunDao
}