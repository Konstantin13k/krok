package od.konstantin.krok.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import od.konstantin.krok.data.repositories.booklets.BookletsShortInfoRepositoryImpl
import od.konstantin.krok.domain.repositories.booklets.BookletsShortInfoRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class BookletsModule {

    @Binds
    abstract fun provideBookletsShortInfoRepository(repository: BookletsShortInfoRepositoryImpl): BookletsShortInfoRepository
}