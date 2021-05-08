package od.konstantin.feature_booklets.di

import dagger.Component
import od.konstantin.core.impl.di.CoreComponent
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_booklets.impl.ui.BookletsFragment

/*
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
}*/
