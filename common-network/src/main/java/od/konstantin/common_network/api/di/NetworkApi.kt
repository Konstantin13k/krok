package od.konstantin.common_network.api.di

import od.konstantin.common_network.api.data.booklets.services.BookletsInfoService
import od.konstantin.module_injector.BaseApi

interface NetworkApi : BaseApi {

    fun bookletsInfoService(): BookletsInfoService
}