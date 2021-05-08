package od.konstantin.core.impl.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import od.konstantin.core.api.di.qualifiers.DefaultDispatcher
import od.konstantin.core.api.di.scopes.AppScope
import od.konstantin.core.api.di.qualifiers.IODispatcher

@Module
class CoroutinesModule {

    @AppScope
    @Provides
    @IODispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @AppScope
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher() : CoroutineDispatcher = Dispatchers.Default
}