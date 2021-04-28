package od.konstantin.feature_booklets.di

import dagger.Module
import dagger.Provides
import od.konstantin.core.di.FeatureScope
import od.konstantin.feature_booklets.ui.BookletsFragment
import od.konstantin.feature_booklets.ui.BookletsFragmentViewModel
import od.konstantin.krok.ui.extensions.viewModel

@Module
class BookletsModule(private val fragment: BookletsFragment) {

    @FeatureScope
    @Provides
    fun provideViewModel() = fragment.viewModel {
        BookletsFragmentViewModel()
    }
}