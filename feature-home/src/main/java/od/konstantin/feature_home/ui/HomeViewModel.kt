package od.konstantin.feature_home.ui

import od.konstantin.feature_home.TestType
import od.konstantin.krok.ui.base.BaseViewModel
import od.konstantin.krok.ui.base.screenstate.EmptyState

class HomeViewModel : BaseViewModel<EmptyState, HomeCommand>(EmptyState) {

    fun selectTestType(testType: TestType) {
        when (testType) {
            TestType.Booklets -> executeCommand(HomeCommand.NavigateToBooklets)
        }
    }
}