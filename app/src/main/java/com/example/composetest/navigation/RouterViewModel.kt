package com.example.composetest.navigation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest.arg.MenuArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

const val NAV_ARG_PAYLOAD = "payload"

@HiltViewModel
class RouterViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {
    val events: SharedFlow<NavEvent> = navigator.events

    fun goTo(route: String, popUpTo: String? = null, inclusive: Boolean = false) {
        viewModelScope.launch { navigator.navigate(route, popUpTo, inclusive) }
    }

    fun moveToMenu(route: String) {
        goTo(route)
    }

    fun moveToMenu(route : String, arg: MenuArg) {
        if(route != arg.route) return
        val json = Json.encodeToString<MenuArg>(arg)
        goTo("${arg.route}?$NAV_ARG_PAYLOAD=${Uri.encode(json)}")
    }

    fun back() {
        viewModelScope.launch { navigator.back() }

    }
}
