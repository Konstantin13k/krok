package od.konstantin.krok.data.repositories.booklets

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import od.konstantin.core.di.qualifiers.IODispatcher
import od.konstantin.core.domain.userprefs.UserPrefs
import od.konstantin.core.domain.userprefs.exam
import od.konstantin.core.domain.userprefs.examLang
import od.konstantin.core.domain.userprefs.specialization
import od.konstantin.core_database.data.booklets.dao.BookletsInfoDao
import od.konstantin.core_network.data.booklets.services.BookletsInfoService
import od.konstantin.core_network.data.safeApiCall
import od.konstantin.core_network.domain.ResultWrapper
import od.konstantin.core_network.domain.Success
import od.konstantin.krok.data.mappers.booklets.entity.BookletShortInfoEntityMapper
import od.konstantin.krok.data.mappers.booklets.network.BookletShortInfoDtoMapper
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import od.konstantin.krok.domain.repositories.booklets.BookletsShortInfoRepository
import javax.inject.Inject

class BookletsShortInfoRepositoryImpl @Inject constructor(
    private val userPrefs: UserPrefs,
    private val bookletsService: BookletsInfoService,
    private val bookletsDao: BookletsInfoDao,
    private val bookletShortInfoDtoMapper: BookletShortInfoDtoMapper,
    private val bookletShortInfoEntityMapper: BookletShortInfoEntityMapper,
    @IODispatcher
    private val ioDispatcher: CoroutineDispatcher
) : BookletsShortInfoRepository {

    override suspend fun getBookletsShortInfo(): ResultWrapper<List<BookletShortInfo>> =
        withContext(ioDispatcher) {
            val bookletsInfo = bookletsDao.getBookletsInfo()
            if (bookletsInfo.isEmpty()) {
                val result = loadBookletsInfo()
                if (result is Success) {
                    saveBookletsInfoToDatabase(result.data)
                }
                result
            } else {
                Success(bookletsInfo.map(bookletShortInfoEntityMapper::map))
            }
        }

    private suspend fun loadBookletsInfo(): ResultWrapper<List<BookletShortInfo>> {
        val specialization = userPrefs.specialization
        val exam = userPrefs.exam
        val examLang = userPrefs.examLang

        return safeApiCall(ioDispatcher) {
            bookletsService.getBookletsInfo(specialization, exam, examLang)
                .bookletsInfo.map(bookletShortInfoDtoMapper::map)
        }
    }

    private suspend fun saveBookletsInfoToDatabase(bookletsInfo: List<BookletShortInfo>) {
        bookletsDao.insertBookletsInfo(bookletsInfo.map(bookletShortInfoEntityMapper::mapToEntity))
    }
}