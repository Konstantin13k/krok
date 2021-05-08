package od.konstantin.core.impl.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import od.konstantin.core.api.di.scopes.AppScope
import od.konstantin.core.api.prefs.UserPrefs
import od.konstantin.core.impl.prefs.UserPrefsImpl

@Module
internal class UserPrefsModule {

    @AppScope
    @Provides
    fun provideUserPrefs(context: Context): UserPrefs {
        return UserPrefsImpl(context)
    }
}