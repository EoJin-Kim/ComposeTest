package com.example.composetest.arg

import kotlinx.serialization.Serializable

@Serializable
sealed interface MenuArg {
    val route: String
}
