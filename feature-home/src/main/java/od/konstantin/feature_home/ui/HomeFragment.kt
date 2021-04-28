package od.konstantin.feature_home.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.feature_home.R
import od.konstantin.feature_home.databinding.FragmentHomeBinding
import od.konstantin.feature_home.di.DaggerHomeComponent
import od.konstantin.feature_home.di.HomeModule
import od.konstantin.feature_home.ui.adapters.TestTypeAdapter
import od.konstantin.krok.ui.base.BaseFragment
import od.konstantin.krok.ui.base.screenstate.EmptyState
import od.konstantin.krok.ui.extensions.viewBindings

class HomeFragment : BaseFragment<EmptyState, HomeCommand, HomeViewModel>(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBindings { FragmentHomeBinding.bind(it) }

    override fun onInitDependencyInjection() {
        DaggerHomeComponent.factory().create(
            CoreComponentHolder.coreComponent,
            HomeModule(this)
        ).inject(this)
    }

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