package od.konstantin.feature_booklets.api.domain

import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo

interface BookletsShortInfoRepository {

    suspend fun getBookletsShortInfo(): List<BookletShortInfo>
}