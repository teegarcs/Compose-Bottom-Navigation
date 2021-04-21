package com.captech.bottomnavdemo.shop

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ShopVM : ViewModel() {
    private val _shopState = mutableStateOf(ShopState.DEFAULT_STATE)
    val shopState: State<ShopState> = _shopState
}