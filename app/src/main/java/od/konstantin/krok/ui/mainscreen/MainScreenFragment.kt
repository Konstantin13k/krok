package od.konstantin.krok.ui.mainscreen

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.presentation.command.EmptyCommand
import od.konstantin.core.ui.BaseFragment
import od.konstantin.core.ui.extensions.setupWithNavController
import od.konstantin.core.ui.extensions.viewBindings
import od.konstantin.krok.R
import od.konstantin.krok.databinding.FragmentMainBinding
import od.konstantin.krok.presentation.mainscreen.MainScreenState
import od.konstantin.krok.presentation.mainscreen.MainScreenViewModel

@AndroidEntryPoint
class MainScreenFragment :
    BaseFragment<MainScreenState, EmptyCommand, MainScreenViewModel>(
        R.layout.fragment_main,
        MainScreenViewModel::class.java
    ) {

    private val binding by viewBindings { FragmentMainBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavBar()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavBar()
    }

    override fun onRenderView(state: MainScreenState) {
        binding.mainBottomNavigation.isVisible = when (state) {
            MainScreenState.NavigationScreen -> true
            MainScreenState.FullScreen -> false
        }
    }

    private fun setupBottomNavBar() {
        val bottomNavView = binding.mainBottomNavigation
        val navGraphIds = listOf(R.navigation.home_graph)

        val controller = bottomNavView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.main_fragment_nav_host_fragment,
            intent = requireActivity().intent
        )

        controller.observe(viewLifecycleOwner, { navController ->
            viewModel.navigationControllerChanged(navController)
        })
    }
}