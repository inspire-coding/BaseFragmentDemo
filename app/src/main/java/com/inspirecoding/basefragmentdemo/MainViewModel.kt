package com.inspirecoding.basefragmentdemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    private val _navigateState = MutableStateFlow(NavigationState.EMPTY)
    val navigateState : StateFlow<NavigationState> = _navigateState

    fun navigateTo (destination : NavigationState) {

        _navigateState.value = destination

    }

}


enum class NavigationState {

    EMPTY,
    FIRST,
    SECOND

}