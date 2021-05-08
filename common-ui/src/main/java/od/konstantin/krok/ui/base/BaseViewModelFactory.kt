package od.konstantin.krok.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import od.konstantin.krok.di.ViewModelComponent
import od.konstantin.krok.ui.base.command.Command
import od.konstantin.krok.ui.base.screenstate.ScreenState

open class BaseViewModelFactory<VM : BaseViewModel<out ScreenState, out Command>> constructor(
    private val viewModelComponent: ViewModelComponent<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = viewModelComponent.viewModel()

        return when (modelClass) {
            viewModel::class.java -> viewModel
            else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
        } as T
    }
}