package od.konstantin.krok.domain.repositories.booklets

import od.konstantin.krok.domain.models.booklets.BookletShortInfo

interface BookletsShortInfoRepository {

    suspend fun getBookletsShortInfo(): List<BookletShortInfo>
}