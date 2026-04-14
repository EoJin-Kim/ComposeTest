package com.example.composetest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetest.navigation.RouterViewModel
import com.example.composetest.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(
    navViewModel: RouterViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        delay(1000)
        navViewModel.goTo(
            route = Routes.MAIN,
            popUpTo = Routes.INTRO,
            inclusive = true
        )
    }
    IntroContent()
}

@Composable
private fun IntroContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3B0)),
        contentAlignment = Alignment.Center
    ) {
        Text("인트로2")
    }
}

@Preview(showBackground = true)
@Composable
private fun IntroScreenPreview() {
    IntroContent()
}
