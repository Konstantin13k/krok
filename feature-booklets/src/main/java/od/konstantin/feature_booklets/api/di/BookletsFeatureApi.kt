package od.konstantin.feature_booklets.api.di

import od.konstantin.feature_booklets.api.domain.BookletsShortInfoRepository
import od.konstantin.module_injector.BaseApi

interface BookletsFeatureApi : BaseApi {

    fun bookletsShortInfoRepository(): BookletsShortInfoRepository
}