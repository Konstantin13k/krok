package od.konstantin.krok.domain.models.booklets

data class BookletShortInfo(
    val bookletId: String,
    val year: Int,
    val questions: Int,
    val subBookletInfo: BookletShortInfo? = null
)