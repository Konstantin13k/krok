package od.konstantin.core_network.data.booklets.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookletsInfoResponse(
    @SerialName("booklets")
    val bookletsInfo: List<BookletShortInfoDto>,
    @SerialName("amount")
    val amount: Int
)