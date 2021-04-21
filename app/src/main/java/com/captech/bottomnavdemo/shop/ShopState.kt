package com.captech.bottomnavdemo.shop

data class ShopState(val itemCount: Int, val showLoading: Boolean) {
    companion object {
        val DEFAULT_STATE = ShopState(0, false)
    }
}
