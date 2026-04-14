package com.example.composetest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetest.arg.SymbolArg
import com.example.composetest.screen.CoinScreen
import com.example.composetest.screen.IntroScreen
import com.example.composetest.screen.MainScreen
import com.example.composetest.screen.SymbolScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    viewModel: RouterViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    LaunchedEffect(navController) {
        viewModel.events.collect { event ->
            when (event) {
                is NavEvent.To -> navController.navigate(event.route) {
                    event.popUpTo?.let { popUpTo(it) { inclusive = event.inclusive } }
                }
                NavEvent.Back -> navController.popBackStack()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.INTRO,
        modifier = modifier
    ) {
        composable(Routes.INTRO) { IntroScreen() }
        composable(Routes.MAIN) { MainScreen() }
        composable(Routes.COIN) { CoinScreen() }
        composable(
            route = routeWithPayload(Routes.SYMBOL),
            arguments = payloadArguments()
        ) { entry ->
            SymbolScreen(entry.payload<SymbolArg>())
        }
    }
}
