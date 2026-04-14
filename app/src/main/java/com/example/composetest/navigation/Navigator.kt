package com.example.composetest.navigation

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

sealed interface NavEvent {
    data class To(val route: String, val popUpTo: String? = null, val inclusive: Boolean = false) : NavEvent
    data object Back : NavEvent
}

interface Navigator {
    val events: SharedFlow<NavEvent>
    suspend fun navigate(route: String, popUpTo: String? = null, inclusive: Boolean = false)
    suspend fun back()
}

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {
    private val _events = MutableSharedFlow<NavEvent>(
        extraBufferCapacity = 16,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val events: SharedFlow<NavEvent> = _events.asSharedFlow()

    override suspend fun navigate(route: String, popUpTo: String?, inclusive: Boolean) {
        _events.emit(NavEvent.To(route, popUpTo, inclusive))
    }

    override suspend fun back() {
        _events.emit(NavEvent.Back)
    }
}
