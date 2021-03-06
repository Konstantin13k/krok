package od.konstantin.feature_welcome.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import od.konstantin.feature_welcome.di.WelcomeComponent
import javax.inject.Inject

class WelcomeFragmentViewModelFactory @Inject constructor(
    private val welcomeComponent: WelcomeComponent
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        WelcomeFragmentViewModel::class.java -> welcomeComponent.viewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}