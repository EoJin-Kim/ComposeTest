package com.example.composetest.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composetest.arg.SymbolArg

@Composable
fun SymbolScreen(arg: SymbolArg?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(arg?.symbol ?: "(심볼 없음)")
    }
}
