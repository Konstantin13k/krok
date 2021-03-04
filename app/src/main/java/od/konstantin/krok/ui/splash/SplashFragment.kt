package od.konstantin.krok.ui.splash

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import od.konstantin.core.RootGraphDirections
import od.konstantin.krok.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().navigate(RootGraphDirections.actionWelcomeFlow())

    }
}