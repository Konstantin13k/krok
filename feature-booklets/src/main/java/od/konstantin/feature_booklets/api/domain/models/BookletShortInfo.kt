package od.konstantin.feature_booklets.api.domain.models

data class BookletShortInfo(
    val bookletId: String,
    val year: Int,
    val questions: Int,
    val subBookletInfo: BookletShortInfo? = null
)