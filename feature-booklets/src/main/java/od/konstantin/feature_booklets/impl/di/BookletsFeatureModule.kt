package od.konstantin.feature_booklets.impl.di

import dagger.Binds
import dagger.Module
import od.konstantin.core.api.di.scopes.FeatureScope
import od.konstantin.feature_booklets.api.domain.BookletsShortInfoRepository
import od.konstantin.feature_booklets.impl.data.BookletsShortInfoRepositoryImpl
import od.konstantin.feature_booklets.impl.ui.BookletsFragmentViewModel
import od.konstantin.feature_booklets.impl.ui.BookletsFragmentViewModelFactory
import od.konstantin.krok.ui.base.BaseViewModelFactory

@Module
internal abstract class BookletsFeatureModule {

    @FeatureScope
    @Binds
    abstract fun provideBookletsShortInfoRepository(repository: BookletsShortInfoRepositoryImpl): BookletsShortInfoRepository

    @FeatureScope
    @Binds
    abstract fun provideViewModelFactory(factory: BookletsFragmentViewModelFactory): BaseViewModelFactory<BookletsFragmentViewModel>
}