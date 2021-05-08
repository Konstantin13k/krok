package od.konstantin.feature_booklets.impl.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import od.konstantin.feature_booklets.api.domain.BookletsShortInfoRepository
import od.konstantin.krok.ui.base.BaseViewModel
import od.konstantin.krok.ui.base.command.EmptyCommand
import od.konstantin.krok.ui.base.screenstate.EmptyState
import javax.inject.Inject

class BookletsFragmentViewModel @Inject constructor(private val bookletsShortInfoRepository: BookletsShortInfoRepository) :
    BaseViewModel<EmptyState, EmptyCommand>(EmptyState) {

    fun test() {
        viewModelScope.launch {
            val bookletsInfo = bookletsShortInfoRepository.getBookletsShortInfo()
            for (bookletInfo in bookletsInfo) {
                Log.d("BOOKLETSINF", bookletInfo.bookletId)
            }
        }
    }
}