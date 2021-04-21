package com.captech.bottomnavdemo.home

import android.text.format.DateFormat
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.*

class HomeVM : ViewModel() {
    private val _homeState = mutableStateOf(HomeState.DEFAULT_STATE)
    val homeState: State<HomeState> = _homeState

    init {
        _homeState.value =
            HomeState("You opened the app at ${DateFormat.format("hh:mm:ss", Date())}")
    }
}