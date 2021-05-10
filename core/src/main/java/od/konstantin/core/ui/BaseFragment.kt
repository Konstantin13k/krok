package od.konstantin.core.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import od.konstantin.core.presentation.BaseViewModel
import od.konstantin.core.presentation.command.Command
import od.konstantin.core.presentation.screenstate.ScreenState
import od.konstantin.core.ui.extensions.observe
import od.konstantin.core.ui.extensions.observeEvent

abstract class BaseFragment<S : ScreenState, C : Command, VM : BaseViewModel<S, C>>(
    @LayoutRes val layoutResId: Int,
    private val viewModelClass: Class<VM>
) : Fragment(layoutResId) {

    protected val viewModel: VM by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    protected open fun onRenderView(state: S) = Unit

    protected open fun executeCommand(command: C) = Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.screenState, ::onRenderView)
        observeEvent(viewModel.command, ::executeCommand)
    }
}