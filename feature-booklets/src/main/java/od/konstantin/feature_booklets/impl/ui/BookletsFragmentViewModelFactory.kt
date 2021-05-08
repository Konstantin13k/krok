package od.konstantin.feature_booklets.impl.ui

import od.konstantin.feature_booklets.impl.di.BookletsFeatureComponent
import od.konstantin.krok.ui.base.BaseViewModelFactory
import javax.inject.Inject

class BookletsFragmentViewModelFactory @Inject constructor(
    bookletsFeatureComponent: BookletsFeatureComponent
) :
    BaseViewModelFactory<BookletsFragmentViewModel>(bookletsFeatureComponent) {

//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
//        BookletsFragmentViewModel::class.java -> TODO()
//        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
//    } as T
}