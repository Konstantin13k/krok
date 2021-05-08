package od.konstantin.feature_booklets.impl.di

import od.konstantin.common_network.api.data.booklets.services.BookletsInfoService
import od.konstantin.common_network.impl.di.NetworkComponent
import od.konstantin.feature_booklets.api.di.BookletsFeatureApi
import od.konstantin.module_injector.ComponentHolder
import od.konstantin.module_injector.NewComponentHolder

object BookletsFeatureComponentHolder :
    ComponentHolder<BookletsFeatureApi, BookletsFeatureDependencies> {

    private var bookletsFeatureComponent: BookletsFeatureComponent? = null

    fun init() = init(
        object : BookletsFeatureDependencies {
            override fun bookletsInfoService(): BookletsInfoService =
                NetworkComponent.get().bookletsInfoService()
        }
    )

    override fun init(dependencies: BookletsFeatureDependencies) {
        if (bookletsFeatureComponent == null) {
            synchronized(BookletsFeatureComponentHolder::class.java) {
                if (bookletsFeatureComponent == null) {
                    bookletsFeatureComponent = BookletsFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): BookletsFeatureApi = getComponent()

    internal fun getComponent(): BookletsFeatureComponent {
        checkNotNull(bookletsFeatureComponent) { "BookletsFeatureComponent was not initialized!" }
        return bookletsFeatureComponent!!
    }

    override fun reset() {
        bookletsFeatureComponent = null
    }
}

object NewBookletsFeatureComponentHolder :
    NewComponentHolder<BookletsFeatureComponent, BookletsFeatureApi, BookletsFeatureDependencies>() {

    fun init() = init(
        object : BookletsFeatureDependencies {
            override fun bookletsInfoService(): BookletsInfoService =
                NetworkComponent.get().bookletsInfoService()
        }
    )

    override fun newComponent(dependencies: BookletsFeatureDependencies): BookletsFeatureComponent =
        BookletsFeatureComponent.initAndGet(dependencies)

    override fun get(): BookletsFeatureApi {
        return checkNotNull(component) { "BookletsFeatureComponent was not initialized!" }
    }
}