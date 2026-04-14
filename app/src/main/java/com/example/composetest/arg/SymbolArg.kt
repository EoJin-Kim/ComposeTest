package com.example.composetest.arg

import com.example.composetest.navigation.Routes
import kotlinx.serialization.Serializable

@Serializable
data class SymbolArg(
    val symbol: String
) : MenuArg {
    override val route: String get() = Routes.SYMBOL
}
