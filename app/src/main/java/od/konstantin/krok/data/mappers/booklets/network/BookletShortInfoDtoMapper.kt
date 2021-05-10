package od.konstantin.krok.data.mappers.booklets.network

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
}