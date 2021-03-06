package od.konstantin.core.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import od.konstantin.core.di.AppScope
import od.konstantin.core.prefs.UserPrefs

@Module
class UserPrefsModule {

    @AppScope
    @Provides
    fun provideUserPrefs(context: Context): UserPrefs {
        return UserPrefs(context)
    }
}