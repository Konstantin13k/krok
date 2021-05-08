package od.konstantin.feature_mainscreen.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import od.konstantin.core.impl.di.CoreComponentHolder
import od.konstantin.feature_mainscreen.R
import od.konstantin.feature_mainscreen.databinding.FragmentMainBinding
import od.konstantin.feature_mainscreen.di.DaggerMainScreenComponent
import od.konstantin.feature_mainscreen.di.MainScreenModule
import od.konstantin.krok.ui.base.BaseFragment
import od.konstantin.krok.ui.base.command.EmptyCommand
import od.konstantin.krok.ui.extensions.setupWithNavController
import od.konstantin.krok.ui.extensions.viewBindings

class MainScreenFragment :
    BaseFragment<MainScreenState, EmptyCommand, MainScreenViewModel>(
        R.layout.fragment_main
    ) {

    private val binding by viewBindings { FragmentMainBinding.bind(it) }

    override val viewModel: MainScreenViewModel by lazy {
        TODO()
    }

    override fun onInitDependencyInjection() {
        DaggerMainScreenComponent.factory().create(
            CoreComponentHolder.coreComponent,
            MainScreenModule(this)
        ).inject(this)
    }

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