package od.konstantin.feature_home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.feature_home.R
import od.konstantin.feature_home.databinding.FragmentHomeBinding
import od.konstantin.feature_home.ui.adapters.TestTypeAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBindings { FragmentHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testTypes.adapter = TestTypeAdapter()
    }
}