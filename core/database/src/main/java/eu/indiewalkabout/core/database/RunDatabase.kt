package eu.indiewalkabout.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.indiewalkabout.core.database.dao.RunDao
import eu.indiewalkabout.core.database.dao.RunPendingSyncDao
import eu.indiewalkabout.core.database.entity.DeletedRunSyncEntity
import eu.indiewalkabout.core.database.entity.RunEntity
import eu.indiewalkabout.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}
