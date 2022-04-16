package ru.maksonic.rdpodcast.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.maksonic.rdpodcast.core.BuildConfig

/**
 * @author maksonic on 14.04.2022
 */
abstract class BaseViewModel<S: UiState, A: UiAction, E: UiEffect>(initialState: S): ViewModel() {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    private val _effect : Channel<E> = Channel()
    val effect: Flow<E>
        get() = _effect.receiveAsFlow()
    abstract val effects: Flow<E>

    protected val uiStackTrace: UiStackTrace<S> = BaseUiStackTrace { storedState ->
        _state.tryEmit(storedState)
    }

    init {
        uiStackTrace.addState(initialState)
    }

    protected fun runAction(action: A) {
        reduce(_state.value, action)
    }

    protected fun setState(newState: S) {
        val success = _state.tryEmit(newState)

        if (BuildConfig.DEBUG && success) {
            uiStackTrace.addState(newState)
        }
    }

    protected fun sendEffect(builder: () -> E) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    abstract fun reduce(oldState: S, action: A)
}