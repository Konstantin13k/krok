package od.konstantin.feature_booklets.di

import dagger.Module
import dagger.Provides
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_booklets.impl.ui.BookletsFragment
import od.konstantin.feature_booklets.impl.ui.BookletsFragmentViewModel
import od.konstantin.krok.ui.extensions.viewModel
import od.konstantin.feature_booklets.api.domain.BookletsShortInfoRepository

/*
@Module
class BookletsModule(private val fragment: BookletsFragment) {

    @FeatureScope
    @Provides
    fun provideViewModel(repository: BookletsShortInfoRepository) = fragment.viewModel {
        BookletsFragmentViewModel(repository)
    }
}*/
