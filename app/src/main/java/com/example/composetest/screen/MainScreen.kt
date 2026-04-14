package com.example.composetest.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetest.arg.SymbolArg
import com.example.composetest.navigation.RouterViewModel
import com.example.composetest.navigation.Routes

@Composable
fun MainScreen(
    navViewModel: RouterViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navViewModel.moveToMenu(Routes.COIN) }) {
            Text("코인 보기")
        }
        Button(onClick = { navViewModel.moveToMenu(SymbolArg("BTC")) }) {
            Text("BTC 심볼")
        }
        Button(onClick = { navViewModel.moveToMenu(SymbolArg("ETH")) }) {
            Text("ETH 심볼")
        }
    }
}
