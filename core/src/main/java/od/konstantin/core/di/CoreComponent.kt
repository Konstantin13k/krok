package od.konstantin.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import od.konstantin.core.prefs.UserPrefs

@AppScope
@Component
interface CoreComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): CoreComponent
    }

//    fun provideUserPrefs(): UserPrefs
}