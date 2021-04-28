package od.konstantin.feature_mainscreen.ui

import od.konstantin.krok.ui.base.screenstate.ScreenState

sealed class MainScreenState : ScreenState {
    object FullScreen : MainScreenState()
    object NavigationScreen : MainScreenState()
}
