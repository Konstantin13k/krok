package od.konstantin.krok.ui.booklets

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.core.ui.BaseFragment
import od.konstantin.core.ui.extensions.viewBindings
import od.konstantin.krok.R
import od.konstantin.krok.databinding.FragmentBookletsBinding
import od.konstantin.krok.domain.models.booklets.BookletShortInfo
import od.konstantin.krok.presentation.booklets.BookletsFragmentViewModel
import od.konstantin.krok.presentation.booklets.BookletsScreenState
import od.konstantin.krok.ui.booklets.adapters.BookletInfoAdapter

@AndroidEntryPoint
class BookletsFragment : BaseFragment<BookletsScreenState, EmptyCommand, BookletsFragmentViewModel>(
    R.layout.fragment_booklets,
    BookletsFragmentViewModel::class.java
) {

    private val binding: FragmentBookletsBinding by viewBindings {
        FragmentBookletsBinding.bind(it)
    }

    private val bookletInfoAdapter by lazy { BookletInfoAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bookletsInfo.adapter = bookletInfoAdapter
    }

    override fun onRenderView(state: BookletsScreenState) {
        when (state) {
            is BookletsScreenState.Loading -> {
                binding.bookletsInfo.isVisible = false
                binding.bookletsLoadingBar.show()
            }
            is BookletsScreenState.BookletsInfo -> {
                binding.bookletsLoadingBar.hide()
                binding.bookletsInfo.isVisible = true
                showBookletsInfo(state.bookletsInfo)
            }
            is BookletsScreenState.NetworkError -> {
                binding.bookletsLoadingBar.hide()
            }
        }
    }

    private fun showBookletsInfo(bookletsInfo: List<BookletShortInfo>) {
        bookletInfoAdapter.submitList(bookletsInfo)
    }
}