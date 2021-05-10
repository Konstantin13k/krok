package od.konstantin.krok.presentation.booklets

import dagger.hilt.android.lifecycle.HiltViewModel
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.core.presentation.screenstate.EmptyState
import od.konstantin.krok.domain.repositories.booklets.BookletsShortInfoRepository
import javax.inject.Inject

@HiltViewModel
class BookletsFragmentViewModel @Inject constructor(
    private val bookletsShortInfoRepository: BookletsShortInfoRepository
) :
    BaseViewModel<EmptyState, EmptyCommand>(EmptyState) {


}