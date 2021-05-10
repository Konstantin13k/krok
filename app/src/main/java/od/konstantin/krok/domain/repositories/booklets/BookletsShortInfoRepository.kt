package od.konstantin.krok.domain.repositories.booklets

import od.konstantin.core_network.domain.ResultWrapper
import od.konstantin.krok.domain.models.booklets.BookletShortInfo

interface BookletsShortInfoRepository {

    suspend fun getBookletsShortInfo(): ResultWrapper<List<BookletShortInfo>>
}