package od.konstantin.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import od.konstantin.core.data.userprefs.UserPrefsImpl
import od.konstantin.core.domain.userprefs.UserPrefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class UserPrefsModule {

    @Singleton
    @Provides
    fun provideUserPrefs(context: Context): UserPrefs {
        return UserPrefsImpl(context)
    }
}