package od.konstantin.common_network.impl.di

import dagger.Component
import od.konstantin.common_network.api.di.NetworkApi
import od.konstantin.common_network.impl.di.modules.BookletsModule
import od.konstantin.common_network.impl.di.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, BookletsModule::class])
abstract class NetworkComponent : NetworkApi {

    companion object {
        @Volatile
        private var coreNetworkComponent: NetworkComponent? = null

        fun get(): NetworkComponent {
            if (coreNetworkComponent == null) {
                synchronized(NetworkComponent::class.java) {
                    if (coreNetworkComponent == null) {
                        coreNetworkComponent = DaggerNetworkComponent.create()
                    }
                }
            }
            return coreNetworkComponent!!
        }
    }
}