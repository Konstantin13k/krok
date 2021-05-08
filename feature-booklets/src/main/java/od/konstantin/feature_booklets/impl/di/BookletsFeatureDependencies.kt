package od.konstantin.feature_booklets.impl.di

import od.konstantin.common_network.api.data.booklets.services.BookletsInfoService
import od.konstantin.module_injector.BaseDependencies

interface BookletsFeatureDependencies : BaseDependencies {

    fun bookletsInfoService(): BookletsInfoService
}