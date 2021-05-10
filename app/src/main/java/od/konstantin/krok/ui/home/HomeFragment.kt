package od.konstantin.krok.ui.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.presentation.screenstate.EmptyState
import od.konstantin.core.ui.BaseFragment
import od.konstantin.core.ui.extensions.viewBindings
import od.konstantin.krok.R
import od.konstantin.krok.databinding.FragmentHomeBinding
import od.konstantin.krok.presentation.home.HomeCommand
import od.konstantin.krok.presentation.home.HomeViewModel
import od.konstantin.krok.ui.home.adapters.TestTypeAdapter

@AndroidEntryPoint
class HomeFragment : BaseFragment<EmptyState, HomeCommand, HomeViewModel>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {

    private val binding: FragmentHomeBinding by viewBindings { FragmentHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun executeCommand(command: HomeCommand) {
        when (command) {
            HomeCommand.NavigateToBooklets -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBookletsFragment())
            }
        }
    }

    private fun initAdapter() {
        binding.testTypes.adapter = TestTypeAdapter(viewModel::selectTestType)
    }
}