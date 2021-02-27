package od.konstantin.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component
interface CoreComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): CoreComponent
    }
}