package od.konstantin.krok.data.mappers.booklets.entity

import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import javax.inject.Inject

class BookletShortInfoEntityMapper @Inject constructor() {

    fun map(info: BookletShortInfoEntity) =
        BookletShortInfo(
            bookletId = info.bookletId,
            year = info.year,
            questions = info.questions,
            subBookletInfo = null,
        )

    fun mapToEntity(info: BookletShortInfo) =
        BookletShortInfoEntity(
            bookletId = info.bookletId,
            year = info.year,
            questions = info.questions,
            isEngSubBooklet = false,
        )
}