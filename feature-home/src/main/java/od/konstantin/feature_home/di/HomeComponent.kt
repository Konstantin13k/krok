package od.konstantin.feature_home.di

import dagger.Component
import od.konstantin.core.impl.di.CoreComponent
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_home.ui.HomeFragment

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [HomeModule::class])
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            homeModule: HomeModule
        ): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}