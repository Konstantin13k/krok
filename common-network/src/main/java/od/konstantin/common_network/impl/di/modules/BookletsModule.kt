package od.konstantin.common_network.impl.di.modules

import dagger.Module
import dagger.Provides
import od.konstantin.common_network.api.data.booklets.services.BookletsInfoService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
internal class BookletsModule {

    @Singleton
    @Provides
    fun provideBookletsService(retrofit: Retrofit): BookletsInfoService =
        retrofit.create(BookletsInfoService::class.java)
}