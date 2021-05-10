package od.konstantin.krok.data.mappers.booklets.network

import od.konstantin.core_database.data.booklets.entities.BookletShortInfoEntity
import od.konstantin.core_network.data.booklets.models.BookletShortInfoDto
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import javax.inject.Inject

class BookletShortInfoDtoMapper @Inject constructor() {

    fun map(info: BookletShortInfoDto) =
        BookletShortInfo(
            bookletId = info.bookletId,
            year = info.year,
            questions = info.questions,
            subBookletInfo = null,
        )

    fun mapToEntity(info: BookletShortInfoDto) =
        BookletShortInfoEntity(
            bookletId = info.bookletId,
            year = info.year,
            questions = info.questions,
            isEngSubBooklet = info.hasEngSubBooklet,
        )
}