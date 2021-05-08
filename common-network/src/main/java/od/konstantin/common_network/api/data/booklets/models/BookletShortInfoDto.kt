package od.konstantin.common_network.api.data.booklets.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookletShortInfoDto(
    @SerialName("id")
    val bookletId: String,
    @SerialName("year")
    val year: Int,
    @SerialName("questions")
    val questions: Int,
    @SerialName("isEngSubBooklet")
    val hasEngSubBooklet: Boolean
)
