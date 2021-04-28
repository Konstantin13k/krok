package od.konstantin.feature_welcome.di

import dagger.Module
import dagger.Provides
import od.konstantin.core.di.FeatureScope
import od.konstantin.core.prefs.UserPrefs
import od.konstantin.feature_welcome.ui.WelcomeFragment
import od.konstantin.feature_welcome.ui.WelcomeFragmentViewModel
import od.konstantin.krok.ui.extensions.viewModel

@Module
class WelcomeModule(
    private val fragment: WelcomeFragment
) {

    @FeatureScope
    @Provides
    fun provideWelcomeViewModel(userPrefs: UserPrefs) = fragment.viewModel {
        WelcomeFragmentViewModel(userPrefs)
    }
}