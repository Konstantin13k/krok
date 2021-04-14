package od.konstantin.feature_welcome.di

import dagger.Component
import od.konstantin.core.di.CoreComponent
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_welcome.ui.WelcomeFragment
import od.konstantin.feature_welcome.ui.WelcomeFragmentViewModel
import od.konstantin.feature_welcome.ui.WelcomeFragmentViewModelFactory

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface WelcomeComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): WelcomeComponent
    }

    fun viewModelFactory(): WelcomeFragmentViewModelFactory

    fun viewModel(): WelcomeFragmentViewModel

    fun inject(fragment: WelcomeFragment)
}