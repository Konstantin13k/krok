package od.konstantin.core_network.data.booklets.services

import android.util.Log
import kotlinx.coroutines.delay
import od.konstantin.core_network.data.booklets.models.BookletShortInfoDto
import od.konstantin.core_network.data.booklets.models.BookletsInfoResponse

class BookletsInfoServicePlug : BookletsInfoService {

    override suspend fun getBookletsInfo(
        specialization: String,
        exam: String,
        examLang: String
    ): BookletsInfoResponse {
        delay(500)
        Log.d("BOOKLETS_INFO", "booklets info service call!")
        return BookletsInfoResponse(
            bookletsInfo = arrayListOf(
                BookletShortInfoDto("id_1", 2020, 150, true),
                BookletShortInfoDto("id_2", 2019, 150, true),
                BookletShortInfoDto("id_3", 2018, 200, false),
                BookletShortInfoDto("id_4", 2017, 200, false),
                BookletShortInfoDto("id_5", 2016, 200, false),
            ),
            amount = 5
        )
    }
}