package od.konstantin.krok.presentation.mainscreen

import od.konstantin.core.presentation.screenstate.ScreenState

sealed class MainScreenState : ScreenState {
    object FullScreen : MainScreenState()
    object NavigationScreen : MainScreenState()
}
