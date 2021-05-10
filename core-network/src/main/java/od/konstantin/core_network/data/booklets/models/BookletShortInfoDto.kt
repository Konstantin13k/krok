package od.konstantin.core_network.data.booklets.models

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
    @SerialName("sub_booklet_info")
    val subBookletInfo: BookletShortInfoDto? = null
)
