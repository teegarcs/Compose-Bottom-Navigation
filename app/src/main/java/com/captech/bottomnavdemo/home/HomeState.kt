package com.captech.bottomnavdemo.home

data class HomeState(val welcomeMessage: String) {
    companion object {
        val DEFAULT_STATE = HomeState("Welcome Friends")
    }
}
