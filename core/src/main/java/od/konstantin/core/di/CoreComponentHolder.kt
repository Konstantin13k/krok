package od.konstantin.core.di

import android.content.Context

object CoreComponentHolder {

    lateinit var coreComponent: CoreComponent
        private set

    fun setupCoreComponent(context: Context) {
        coreComponent = DaggerCoreComponent.factory().create(context)
    }
}