package od.konstantin.core.impl.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import od.konstantin.core.api.di.CoreApi
import od.konstantin.core.api.di.scopes.AppScope
import od.konstantin.core.impl.di.modules.CoroutinesModule
import od.konstantin.core.impl.di.modules.UserPrefsModule

@AppScope
@Component(modules = [UserPrefsModule::class, CoroutinesModule::class])
interface CoreComponent : CoreApi {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): CoreComponent
    }
}