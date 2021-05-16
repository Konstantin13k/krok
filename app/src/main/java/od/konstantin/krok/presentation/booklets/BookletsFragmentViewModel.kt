package od.konstantin.krok.presentation.booklets

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.core_network.domain.GenericError
import od.konstantin.core_network.domain.NetworkError
import od.konstantin.core_network.domain.Success
import od.konstantin.krok.domain.repositories.booklets.BookletsShortInfoRepository
import javax.inject.Inject

@HiltViewModel
class BookletsFragmentViewModel @Inject constructor(
    private val bookletsShortInfoRepository: BookletsShortInfoRepository
) :
    BaseViewModel<BookletsScreenState, EmptyCommand>(BookletsScreenState.Loading) {

    init {
        loadBookletsInfo()
    }

    private fun loadBookletsInfo() {
        viewModelScope.launch {
            when (val bookletsInfoResult = bookletsShortInfoRepository.getBookletsShortInfo()) {
                is Success -> updateScreenState(BookletsScreenState.BookletsInfo(bookletsInfoResult.data))
                is NetworkError -> updateScreenState(BookletsScreenState.NetworkError)
                is GenericError -> updateScreenState(BookletsScreenState.NetworkError)
            }
        }
    }

    fun onRetryLoadBookletsInfo() {
        updateScreenState(BookletsScreenState.Loading)
        loadBookletsInfo()
    }
}