package od.konstantin.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import od.konstantin.core.domain.models.Event
import od.konstantin.core.presentation.command.Command
import od.konstantin.core.presentation.screenstate.ScreenState

abstract class BaseViewModel<S : ScreenState, C : Command>(initialState: S) : ViewModel() {

    private val _screenState = MutableStateFlow(initialState)
    val screenState: StateFlow<S> = _screenState.asStateFlow()

    protected fun updateScreenState(newState: S) {
        viewModelScope.launch {
            _screenState.emit(newState)
        }
    }

    private val _command = MutableLiveData<Event<C>>()
    val command: LiveData<Event<C>>
        get() = _command

    protected fun executeCommand(command: C) {
        _command.value = Event(command)
    }
}