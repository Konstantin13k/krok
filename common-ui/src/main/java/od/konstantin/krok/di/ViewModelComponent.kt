package od.konstantin.krok.di

import od.konstantin.krok.ui.base.BaseViewModel
import od.konstantin.krok.ui.base.BaseViewModelFactory
import od.konstantin.krok.ui.base.command.Command
import od.konstantin.krok.ui.base.screenstate.ScreenState

interface ViewModelComponent<VM : BaseViewModel<out ScreenState, out Command>> {

    fun viewModel(): VM
}