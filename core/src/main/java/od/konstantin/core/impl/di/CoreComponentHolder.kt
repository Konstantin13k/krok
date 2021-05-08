package od.konstantin.core.impl.di

import android.content.Context
import od.konstantin.core.api.di.CoreApi

object CoreComponentHolder {

    lateinit var coreComponent: CoreComponent

    fun setupCoreComponent(context: Context) {
        coreComponent = DaggerCoreComponent.factory().create(context)
    }

    fun get(): CoreApi = coreComponent
}