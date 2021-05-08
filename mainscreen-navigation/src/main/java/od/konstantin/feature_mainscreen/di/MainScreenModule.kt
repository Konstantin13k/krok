package od.konstantin.feature_mainscreen.di

import dagger.Module
import dagger.Provides
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_mainscreen.ui.MainScreenFragment
import od.konstantin.feature_mainscreen.ui.MainScreenViewModel
import od.konstantin.krok.ui.extensions.viewModel

@Module
class MainScreenModule(
    private val fragment: MainScreenFragment
) {

    @FeatureScope
    @Provides
    fun provideWelcomeViewModel() = fragment.viewModel {
        MainScreenViewModel()
    }
}