package od.konstantin.feature_booklets.di

import dagger.Component
import od.konstantin.core.di.CoreComponent
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_booklets.ui.BookletsFragment

@FeatureScope
@Component(dependencies = [CoreComponent::class], modules = [BookletsModule::class])
interface BookletsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            bookletsModule: BookletsModule
        ): BookletsComponent
    }

    fun inject(fragment: BookletsFragment)
}