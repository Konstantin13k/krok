package od.konstantin.krok.data.mappers.booklets.entity

import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity
import od.konstantin.core_database.data.booklets.entities.BookletWithSubBookletInfo
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import javax.inject.Inject

class BookletShortInfoEntityMapper @Inject constructor() {

    fun map(booklets: BookletWithSubBookletInfo) =
        BookletShortInfo(
            bookletId = booklets.bookletInfo.bookletId,
            year = booklets.bookletInfo.year,
            questions = booklets.bookletInfo.questions,
            subBookletInfo = booklets.subBookletInfo?.let { subBookletInfo ->
                BookletShortInfo(
                    bookletId = subBookletInfo.bookletId,
                    year = subBookletInfo.year,
                    questions = subBookletInfo.questions,
                )
            },
        )

    fun mapToEntity(info: BookletShortInfo, isSubBooklet: Boolean) =
        BookletShortInfoEntity(
            bookletId = info.bookletId,
            year = info.year,
            questions = info.questions,
            isSubBooklet = isSubBooklet,
            subBookletId = info.subBookletInfo?.bookletId,
        )
}