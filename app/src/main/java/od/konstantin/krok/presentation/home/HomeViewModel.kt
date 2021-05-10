package od.konstantin.krok.presentation.home

import dagger.hilt.android.lifecycle.HiltViewModel
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.screenstate.EmptyState
import od.konstantin.krok.domain.models.TestType
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<EmptyState, HomeCommand>(EmptyState) {

    fun selectTestType(testType: TestType) {
        when (testType) {
            TestType.Booklets -> executeCommand(HomeCommand.NavigateToBooklets)
        }
    }
}