package od.konstantin.krok.presentation.home

import od.konstantin.core.presentation.command.Command

sealed class HomeCommand : Command {
    object NavigateToBooklets : HomeCommand()
}