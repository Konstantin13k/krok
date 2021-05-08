package od.konstantin.feature_booklets.impl.di

import dagger.Component
import od.konstantin.core.api.di.CoreApi
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.core.impl.di.CoreComponent
import od.konstantin.core.impl.di.CoreComponentHolder
import od.konstantin.feature_booklets.api.di.BookletsFeatureApi
import od.konstantin.feature_booklets.impl.ui.BookletsFragment
import od.konstantin.feature_booklets.impl.ui.BookletsFragmentViewModel
import od.konstantin.feature_booklets.impl.ui.BookletsFragmentViewModelFactory
import od.konstantin.krok.di.ViewModelComponent

@FeatureScope
@Component(
    dependencies = [CoreApi::class, BookletsFeatureDependencies::class],
    modules = [BookletsFeatureModule::class]
)
abstract class BookletsFeatureComponent : BookletsFeatureApi,
    ViewModelComponent<BookletsFragmentViewModel> {

    companion object {
        fun initAndGet(dependencies: BookletsFeatureDependencies): BookletsFeatureComponent {
            return DaggerBookletsFeatureComponent.builder()
                .bookletsFeatureDependencies(dependencies)
                .coreApi(CoreComponentHolder.coreComponent)
                .build()
        }
    }

//    abstract fun viewModelFactory(): BookletsFragmentViewModelFactory

//    abstract fun viewModel(): BookletsFragmentViewModel

    abstract fun inject(fragment: BookletsFragment)
}