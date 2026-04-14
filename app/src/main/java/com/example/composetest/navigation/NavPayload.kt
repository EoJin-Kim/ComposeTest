package com.example.composetest.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

val NavJson = Json { ignoreUnknownKeys = true }

fun routeWithPayload(route: String) = "$route?$NAV_ARG_PAYLOAD={$NAV_ARG_PAYLOAD}"

fun payloadArguments(): List<NamedNavArgument> = listOf(
    navArgument(NAV_ARG_PAYLOAD) {
        type = NavType.StringType
        nullable = true
        defaultValue = null
    }
)

inline fun <reified T : Any> NavBackStackEntry.payload(): T? {
    val raw = arguments?.getString(NAV_ARG_PAYLOAD) ?: return null
    return NavJson.decodeFromString(serializer<T>(), raw)
}
