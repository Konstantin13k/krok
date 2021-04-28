package od.konstantin.feature_mainscreen.ui

import androidx.navigation.NavController
import od.konstantin.feature_mainscreen.R
import od.konstantin.krok.ui.base.BaseViewModel
import od.konstantin.krok.ui.base.command.EmptyCommand

internal val NAV_FRAGMENTS_ID = setOf(R.id.homeFragment)

class MainScreenViewModel :
    BaseViewModel<MainScreenState, EmptyCommand>(MainScreenState.NavigationScreen) {

    fun navigationControllerChanged(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (NAV_FRAGMENTS_ID.contains(destination.id)) {
                updateScreenState(MainScreenState.NavigationScreen)
            } else {
                updateScreenState(MainScreenState.FullScreen)
            }
        }
    }
}