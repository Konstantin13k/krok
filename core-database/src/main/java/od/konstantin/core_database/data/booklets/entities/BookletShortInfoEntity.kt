package od.konstantin.core_database.data.booklets.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booklets_info")
data class BookletShortInfoEntity(
    @PrimaryKey
    @ColumnInfo(name = "booklet_id")
    val bookletId: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "questions")
    val questions: Int,
    @ColumnInfo(name = "is_sub_booklet")
    val isSubBooklet: Boolean,
    @ColumnInfo(name = "sub_booklet_id")
    val subBookletId: String? = null,
)