package od.konstantin.common_network.api.data.booklets.models

import kotlinx.serialization.SerialName

data class BookletsInfoResponse(
    @SerialName("booklets")
    val bookletsInfo: List<BookletShortInfoDto>,
    @SerialName("amount")
    val amount: Int
) {
}