package od.konstantin.krok.ui.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

inline fun <reified BindingT : ViewBinding> Fragment.viewBindings(
    crossinline bind: (View) -> BindingT
) = object : Lazy<BindingT> {
    private var cached: BindingT? = null

    private val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            cached = null
        }
    }

    override val value: BindingT
        get() = cached ?: bind(requireView()).also {
            viewLifecycleOwner.lifecycle.addObserver(observer)
            cached = it
        }

    override fun isInitialized(): Boolean = cached != null
}

@Suppress("UNCHECKED_CAST")
fun <VM : ViewModel> Fragment.viewModel(
    key: String? = null,
    factory: () -> VM
): VM {
    val factoryViewModel = factory()
    val viewModelProviderFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return factoryViewModel as T
        }
    }

    return if (key != null) {
        ViewModelProvider(this, viewModelProviderFactory).get(key, factoryViewModel::class.java)
    } else {
        ViewModelProvider(this, viewModelProviderFactory).get(factoryViewModel::class.java)
    }
}