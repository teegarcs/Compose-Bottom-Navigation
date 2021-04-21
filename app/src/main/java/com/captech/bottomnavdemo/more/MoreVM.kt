package com.captech.bottomnavdemo.more

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MoreVM : ViewModel() {
    private val _moreState = mutableStateOf(MoreState.DEFAULT_STATE)
    val moreState: State<MoreState> = _moreState
    private val words = listOf("CapTech", "Others", "Talk", "We", "Listen")

    fun processIntent(moreIntent: MoreIntent) {
        when (moreIntent) {
            is MoreIntent.GenerateNewText -> generateNewWord()
        }
    }

    private fun generateNewWord() {
        val word = words[Random.nextInt(0, words.size)]
        _moreState.value = MoreState(word)
    }
}