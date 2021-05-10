package od.konstantin.krok.data.repositories.booklets

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import od.konstantin.core.di.qualifiers.IODispatcher
import od.konstantin.core.domain.userprefs.UserPrefs
import od.konstantin.core.domain.userprefs.exam
import od.konstantin.core.domain.userprefs.examLang
import od.konstantin.core.domain.userprefs.specialization
import od.konstantin.core_network.data.booklets.services.BookletsInfoService
import od.konstantin.core_network.data.safeApiCall
import od.konstantin.core_network.domain.ResultWrapper
import od.konstantin.krok.data.mappers.booklets.network.BookletShortInfoDtoMapper
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import od.konstantin.krok.domain.repositories.booklets.BookletsShortInfoRepository
import javax.inject.Inject

class BookletsShortInfoRepositoryImpl @Inject constructor(
    private val userPrefs: UserPrefs,
    private val bookletsService: BookletsInfoService,
    private val bookletShortInfoDtoMapper: BookletShortInfoDtoMapper,
    @IODispatcher
    private val ioDispatcher: CoroutineDispatcher
) : BookletsShortInfoRepository {

    override suspend fun getBookletsShortInfo(): ResultWrapper<List<BookletShortInfo>> =
        withContext(ioDispatcher) {
            val specialization = userPrefs.specialization
            val exam = userPrefs.exam
            val examLang = userPrefs.examLang

            safeApiCall(ioDispatcher) {
                val bookletsInfo = bookletsService.getBookletsInfo(specialization, exam, examLang)
                bookletsInfo.bookletsInfo.map(bookletShortInfoDtoMapper::map)
            }
        }
}