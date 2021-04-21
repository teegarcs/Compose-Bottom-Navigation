package com.captech.bottomnavdemo.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    // ViewModel scoped to BackStackEntry, will reset every time composable is removed and added again
    val homeVM: HomeVM = viewModel()
    BuildHome(state = homeVM.homeState.value)
}

@Composable
fun BuildHome(state: HomeState) {
    Text(text = state.welcomeMessage, textAlign = TextAlign.Center)
}

@Composable
@Preview(showBackground = true)
fun PreviewHome() {
    BuildHome(state = HomeState.DEFAULT_STATE)
}