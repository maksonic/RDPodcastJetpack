package ru.maksonic.rdpodcast.core.base

/**
 * @author maksonic on 14.04.2022
 */
interface UiStackTrace<S : UiState> {
    fun addState(state: S)
    fun selectState(position: Int)
    fun getStates(): List<S>
}

class BaseUiStackTrace<S : UiState>(
    private val onStateSelected: (S) -> Unit
) : UiStackTrace<S> {

    private val states = mutableListOf<S>()

    override fun addState(state: S) {
        states.add(state)
    }

    override fun selectState(position: Int) {
        onStateSelected(states[position])
    }

    override fun getStates(): List<S> {
        return states
    }
}