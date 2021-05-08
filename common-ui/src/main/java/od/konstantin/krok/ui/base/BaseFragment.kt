package od.konstantin.krok.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import od.konstantin.krok.ui.base.command.Command
import od.konstantin.krok.ui.base.screenstate.ScreenState
import od.konstantin.krok.ui.extensions.observe
import od.konstantin.krok.ui.extensions.observeEvent
import javax.inject.Inject

abstract class BaseFragment<S : ScreenState, C : Command, VM : BaseViewModel<S, C>>(
    @LayoutRes val layoutResId: Int
) : Fragment(layoutResId) {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<VM>

    abstract val viewModel: VM

    protected abstract fun onInitDependencyInjection()

    protected open fun onRenderView(state: S) = Unit

    protected open fun executeCommand(command: C) = Unit

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onInitDependencyInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.screenState, ::onRenderView)
        observeEvent(viewModel.command, ::executeCommand)
    }
}