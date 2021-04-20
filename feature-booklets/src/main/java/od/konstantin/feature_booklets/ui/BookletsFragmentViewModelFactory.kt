package od.konstantin.feature_booklets.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import od.konstantin.feature_booklets.di.BookletsComponent
import javax.inject.Inject

class BookletsFragmentViewModelFactory @Inject constructor(
    private val bookletsComponent: BookletsComponent
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        BookletsFragmentViewModel::class.java -> bookletsComponent.viewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}