package od.konstantin.krok

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import od.konstantin.core.di.CoreComponentHolder
import od.konstantin.core.prefs.isNeedToFillProfile

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (CoreComponentHolder.coreComponent.provideUserPrefs().isNeedToFillProfile()) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
        } else {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainScreenFragment())
        }
    }
}