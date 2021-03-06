package od.konstantin.feature_welcome.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import od.konstantin.core.RootGraphDirections
import od.konstantin.core.exam.Category
import od.konstantin.core.util.extensions.viewBindings
import od.konstantin.feature_welcome.R
import od.konstantin.feature_welcome.databinding.FragmentWelcomeBinding
import java.util.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private val binding by viewBindings { FragmentWelcomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmButton.setOnClickListener {
            findNavController().navigate(RootGraphDirections.actionMainscreenFlow())
        }
    }
}