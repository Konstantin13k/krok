package od.konstantin.feature_booklets.di

import dagger.Component
import od.konstantin.core.di.CoreComponent
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_booklets.ui.BookletsFragment
import od.konstantin.feature_booklets.ui.BookletsFragmentViewModel
import od.konstantin.feature_booklets.ui.BookletsFragmentViewModelFactory

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface BookletsComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): BookletsComponent
    }

    fun viewModelFactory(): BookletsFragmentViewModelFactory

    fun viewModel(): BookletsFragmentViewModel

    fun inject(fragment: BookletsFragment)
}