package od.konstantin.feature_booklets.impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import od.konstantin.feature_booklets.R
import od.konstantin.feature_booklets.databinding.FragmentBookletsBinding
import od.konstantin.feature_booklets.impl.di.BookletsFeatureComponentHolder
import od.konstantin.feature_booklets.impl.ui.adapters.BookletInfoAdapter
import od.konstantin.krok.ui.base.BaseFragment
import od.konstantin.krok.ui.base.command.EmptyCommand
import od.konstantin.krok.ui.base.screenstate.EmptyState
import od.konstantin.krok.ui.extensions.viewBindings
import javax.inject.Inject

class BookletsFragment : BaseFragment<EmptyState, EmptyCommand, BookletsFragmentViewModel>(
    R.layout.fragment_booklets
) {

    private val binding: FragmentBookletsBinding by viewBindings {
        FragmentBookletsBinding.bind(it)
    }

    override val viewModel: BookletsFragmentViewModel by viewModels {
        viewModelFactory
    }

    override fun onInitDependencyInjection() {
        BookletsFeatureComponentHolder.init()
        BookletsFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookletInfoAdapter()
        binding.bookletsInfo.adapter = adapter
        viewModel.test()
    }

    override fun onPause() {
        super.onPause()
        if (isRemoving) {
            BookletsFeatureComponentHolder.reset()
        }
    }
}