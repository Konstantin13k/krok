package od.konstantin.feature_welcome.di

import dagger.Component
import od.konstantin.core.impl.di.CoreComponent
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_welcome.ui.WelcomeFragment

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [WelcomeModule::class])
interface WelcomeComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            welcomeModule: WelcomeModule
        ): WelcomeComponent
    }

    fun inject(fragment: WelcomeFragment)
}