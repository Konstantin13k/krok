package od.konstantin.feature_booklets.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.feature_booklets.R
import od.konstantin.feature_booklets.databinding.FragmentBookletsBinding
import od.konstantin.feature_booklets.di.DaggerBookletsComponent
import od.konstantin.feature_booklets.ui.adapters.BookletInfoAdapter
import javax.inject.Inject

class BookletsFragment : Fragment(R.layout.fragment_booklets) {

    @Inject
    lateinit var viewModelFactory: BookletsFragmentViewModelFactory

    private val viewmodel: BookletsFragmentViewModel by viewModels {
        viewModelFactory
    }

    private val binding: FragmentBookletsBinding by viewBindings { FragmentBookletsBinding.bind(it) }

    override fun onAttach(context: Context) {
        DaggerBookletsComponent.factory().create(CoreComponentHolder.coreComponent)
            .inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookletInfoAdapter()
        binding.bookletsInfo.adapter = adapter
    }
}