package od.konstantin.krok.ui.booklets

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.core.presentation.screenstate.EmptyState
import od.konstantin.core.ui.BaseFragment
import od.konstantin.core.ui.extensions.viewBindings
import od.konstantin.krok.R
import od.konstantin.krok.databinding.FragmentBookletsBinding
import od.konstantin.krok.presentation.booklets.BookletsFragmentViewModel
import od.konstantin.krok.ui.booklets.adapters.BookletInfoAdapter

@AndroidEntryPoint
class BookletsFragment : BaseFragment<EmptyState, EmptyCommand, BookletsFragmentViewModel>(
    R.layout.fragment_booklets,
    BookletsFragmentViewModel::class.java
) {

    private val binding: FragmentBookletsBinding by viewBindings {
        FragmentBookletsBinding.bind(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookletInfoAdapter()
        binding.bookletsInfo.adapter = adapter
    }
}