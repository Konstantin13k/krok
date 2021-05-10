package od.konstantin.core_database.data.booklets.dao

import androidx.room.*
import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity
import od.konstantin.core_database.data.booklets.entities.BookletWithSubBookletInfo

@Dao
interface BookletsInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookletsInfo(bookletsInfo: List<BookletShortInfoEntity>)

    @Transaction
    @Query("SELECT * FROM booklets_info WHERE is_sub_booklet = 0")
    suspend fun getBookletsInfo(): List<BookletWithSubBookletInfo>

    @Query("DELETE FROM booklets_info")
    suspend fun deleteAll()
}