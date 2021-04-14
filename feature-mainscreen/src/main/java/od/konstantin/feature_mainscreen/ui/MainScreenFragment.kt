package od.konstantin.feature_mainscreen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.feature_mainscreen.R
import od.konstantin.feature_mainscreen.databinding.FragmentMainBinding

class MainScreenFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBindings { FragmentMainBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hostFragment =
            childFragmentManager.findFragmentById(R.id.main_fragment_nav_host_fragment) as? NavHostFragment
        hostFragment?.findNavController()?.let {
            binding.mainBottomNavigation.setupWithNavController(it)
        }
    }
}