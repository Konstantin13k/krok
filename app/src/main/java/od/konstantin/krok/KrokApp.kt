package od.konstantin.krok

import android.app.Application
import od.konstantin.core.impl.di.CoreComponentHolder

class KrokApp : Application() {

    override fun onCreate() {
        super.onCreate()
        CoreComponentHolder.setupCoreComponent(applicationContext)
    }
}