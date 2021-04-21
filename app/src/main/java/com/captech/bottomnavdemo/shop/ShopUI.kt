package com.captech.bottomnavdemo.shop

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ShopScreen() {
    // ViewModel scoped to Composable, will reset every time composable is removed and added again
    val shopVM: ShopVM = viewModel()
    BuildShop(state = shopVM.shopState.value)
}

@Composable
fun BuildShop(state: ShopState) {

}

@Composable
@Preview(showBackground = true)
fun PreviewShop() {
    BuildShop(state = ShopState.DEFAULT_STATE)
}