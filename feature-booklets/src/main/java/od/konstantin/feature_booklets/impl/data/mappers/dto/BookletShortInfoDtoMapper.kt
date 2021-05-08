package od.konstantin.feature_booklets.impl.data.mappers.dto

import od.konstantin.common_network.api.data.booklets.models.BookletShortInfoDto
import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo
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