package od.konstantin.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import od.konstantin.core.di.modules.UserPrefsModule
import od.konstantin.core.prefs.UserPrefs
import od.konstantin.core.prefs.UserPrefsImpl

@AppScope
@Component(modules = [UserPrefsModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideUserPrefs(): UserPrefs
}