package od.konstantin.krok.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import od.konstantin.core.domain.userprefs.UserPrefs
import od.konstantin.core.domain.userprefs.isNeedToFillProfile
import od.konstantin.krok.R
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var userPreferences: UserPrefs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (userPreferences.isNeedToFillProfile()) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWelcomeFragment())
        } else {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainScreenFragment())
        }
    }
}