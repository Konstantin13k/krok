package od.konstantin.krok.presentation.booklets

import od.konstantin.core.presentation.screenstate.ScreenState
import od.konstantin.krok.domain.models.booklets.BookletShortInfo

sealed class BookletsScreenState : ScreenState {
    object Loading : BookletsScreenState()
    object NetworkError : BookletsScreenState()
    class BookletsInfo(val bookletsInfo: List<BookletShortInfo>) : BookletsScreenState()
}