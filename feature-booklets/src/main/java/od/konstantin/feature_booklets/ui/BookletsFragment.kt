package od.konstantin.feature_booklets.ui

import android.os.Bundle
import android.view.View
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.feature_booklets.R
import od.konstantin.feature_booklets.databinding.FragmentBookletsBinding
import od.konstantin.feature_booklets.di.BookletsModule
import od.konstantin.feature_booklets.di.DaggerBookletsComponent
import od.konstantin.feature_booklets.ui.adapters.BookletInfoAdapter
import od.konstantin.krok.ui.base.BaseFragment
import od.konstantin.krok.ui.base.command.EmptyCommand
import od.konstantin.krok.ui.base.screenstate.EmptyState
import od.konstantin.krok.ui.extensions.viewBindings

class BookletsFragment : BaseFragment<EmptyState, EmptyCommand, BookletsFragmentViewModel>(
    R.layout.fragment_booklets
) {

    private val binding: FragmentBookletsBinding by viewBindings { FragmentBookletsBinding.bind(it) }

    override fun onInitDependencyInjection() {
        DaggerBookletsComponent.factory().create(
            CoreComponentHolder.coreComponent,
            BookletsModule(this)
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookletInfoAdapter()
        binding.bookletsInfo.adapter = adapter
    }
}