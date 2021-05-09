package od.konstantin.core_network.data.booklets.services

import od.konstantin.core_network.data.booklets.models.BookletsInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookletsInfoService {

    @GET("/booklets/{specialization}/{exam}/info")
    suspend fun getBookletsInfo(
        @Path("specialization") specialization: String,
        @Path("exam") exam: String,
        @Query("lang") examLang: String
    ): BookletsInfoResponse
}