package od.konstantin.feature_booklets.impl.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import od.konstantin.common_network.api.data.booklets.services.BookletsInfoService
import od.konstantin.core.api.di.qualifiers.IODispatcher
import od.konstantin.core.api.prefs.UserPrefs
import od.konstantin.core.util.extensions.exam
import od.konstantin.core.util.extensions.examLang
import od.konstantin.core.util.extensions.specialization
import od.konstantin.feature_booklets.api.domain.BookletsShortInfoRepository
import od.konstantin.feature_booklets.api.domain.models.BookletShortInfo
import od.konstantin.feature_booklets.impl.data.mappers.dto.BookletShortInfoDtoMapper
import javax.inject.Inject

class BookletsShortInfoRepositoryImpl @Inject constructor(
    private val userPrefs: UserPrefs,
    private val bookletsService: BookletsInfoService,
    private val bookletShortInfoDtoMapper: BookletShortInfoDtoMapper,
    @IODispatcher
    private val ioDispatcher: CoroutineDispatcher
) : BookletsShortInfoRepository {

    override suspend fun getBookletsShortInfo(): List<BookletShortInfo> =
        withContext(ioDispatcher) {
            val specialization = userPrefs.specialization
            val exam = userPrefs.exam
            val examLang = userPrefs.examLang

            val bookletsInfo = bookletsService.getBookletsInfo(specialization, exam, examLang)
            bookletsInfo.bookletsInfo.map(bookletShortInfoDtoMapper::map)
        }
}