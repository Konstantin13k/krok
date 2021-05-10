package od.konstantin.krok.presentation.mainscreen

import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.krok.R
import javax.inject.Inject

internal val NAV_FRAGMENTS_ID = setOf(R.id.homeFragment)

@HiltViewModel
class MainScreenViewModel @Inject constructor() :
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