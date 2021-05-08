package od.konstantin.krok

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import od.konstantin.core.api.prefs.isNeedToFillProfile
import od.konstantin.core.impl.di.CoreComponentHolder

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (CoreComponentHolder.get().userPreferences().isNeedToFillProfile()) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
        } else {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainScreenFragment())
        }
    }
}