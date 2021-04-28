package od.konstantin.feature_home.ui

import od.konstantin.krok.ui.base.command.Command

sealed class HomeCommand : Command {
    object NavigateToBooklets : HomeCommand()
}