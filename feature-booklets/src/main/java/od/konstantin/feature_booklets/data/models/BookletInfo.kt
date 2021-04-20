package od.konstantin.feature_booklets.data.models

data class BookletInfo(
    val bookletId: String,
    val year: Int,
    val questions: Int,
    val subBookletInfo: BookletInfo? = null
)