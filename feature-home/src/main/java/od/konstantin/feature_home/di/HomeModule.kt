package od.konstantin.feature_home.di

import dagger.Module
import dagger.Provides
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_home.ui.HomeFragment
import od.konstantin.feature_home.ui.HomeViewModel
import od.konstantin.krok.ui.extensions.viewModel

@Module
class HomeModule(
    private val fragment: HomeFragment
) {

    @FeatureScope
    @Provides
    fun provideViewModule() = fragment.viewModel {
        HomeViewModel()
    }
}