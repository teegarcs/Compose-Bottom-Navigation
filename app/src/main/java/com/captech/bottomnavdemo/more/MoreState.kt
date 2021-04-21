package com.captech.bottomnavdemo.more

data class MoreState(val randomText: String) {
    companion object {
        val DEFAULT_STATE = MoreState("Random")
    }
}
