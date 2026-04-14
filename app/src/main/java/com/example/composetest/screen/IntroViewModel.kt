package com.example.composetest.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface IntroSideEffect {
    data object GoToMain : IntroSideEffect
}

@HiltViewModel
class IntroViewModel @Inject constructor() : ViewModel() {
    private val _effect = MutableSharedFlow<IntroSideEffect>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val effect: SharedFlow<IntroSideEffect> = _effect.asSharedFlow()

    fun onStartClick() {
        viewModelScope.launch { _effect.emit(IntroSideEffect.GoToMain) }
    }
}
