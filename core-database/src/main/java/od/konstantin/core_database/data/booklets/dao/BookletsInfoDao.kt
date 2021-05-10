package od.konstantin.core_database.data.booklets.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity

@Dao
interface BookletsInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookletsInfo(bookletsInfo: List<BookletShortInfoEntity>)

    @Query("SELECT * FROM booklets_info")
    suspend fun getBookletsInfo(): List<BookletShortInfoEntity>

    @Query("DELETE FROM booklets_info")
    suspend fun deleteAll()
}