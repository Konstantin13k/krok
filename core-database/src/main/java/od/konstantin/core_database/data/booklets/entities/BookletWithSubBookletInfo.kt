package od.konstantin.core_database.data.booklets.entities

import androidx.room.Embedded
import androidx.room.Relation

data class BookletWithSubBookletInfo(
    @Embedded
    val bookletInfo: BookletShortInfoEntity,
    @Relation(parentColumn = "sub_booklet_id", entityColumn = "booklet_id")
    val subBookletInfo: BookletShortInfoEntity? = null
)