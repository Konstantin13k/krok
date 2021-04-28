package od.konstantin.feature_mainscreen.di

import dagger.Component
import od.konstantin.core.di.CoreComponent
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_mainscreen.ui.MainScreenFragment

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [MainScreenModule::class])
interface MainScreenComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            mainScreenModule: MainScreenModule
        ): MainScreenComponent
    }

    fun inject(fragment: MainScreenFragment)
}