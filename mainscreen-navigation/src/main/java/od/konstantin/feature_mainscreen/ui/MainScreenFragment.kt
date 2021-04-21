package od.konstantin.feature_mainscreen.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.core_navigation.utils.extensions.setupWithNavController
import od.konstantin.feature_mainscreen.R
import od.konstantin.feature_mainscreen.databinding.FragmentMainBinding

class MainScreenFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBindings { FragmentMainBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            setupBottomNavBar()
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
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment -> bottomNavView.isVisible = true
                    else -> bottomNavView.isVisible = false
                }
            }
        })
    }
}