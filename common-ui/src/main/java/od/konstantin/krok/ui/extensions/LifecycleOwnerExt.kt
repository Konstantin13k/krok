package od.konstantin.krok.ui.extensions

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import od.konstantin.core.util.Event

inline fun <T> LifecycleOwner.observe(flow: Flow<T>, crossinline observer: (T) -> Unit) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                observer(it)
            }
        }
    }
}

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline observer: (T) -> Unit) {
    liveData.observe(this, Observer {
        observer(it)
    })
}

inline fun <T> LifecycleOwner.observeEvent(
    liveData: LiveData<Event<T>>,
    crossinline observer: (T) -> Unit
) {
    liveData.observe(this, Observer {
        it.getContentIfNotHandled()?.let(observer)
    })
}