package od.konstantin.core_database.data

import androidx.room.Database
import androidx.room.RoomDatabase
import od.konstantin.core_database.data.booklets.dao.BookletsInfoDao
import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity

@Database(
    entities = [
        BookletShortInfoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class KrokDatabase : RoomDatabase() {

    abstract val bookletsInfoDao: BookletsInfoDao
}