package com.captech.bottomnavdemo.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MoreScreen() {
    // ViewModel scoped to Composable, will reset every time composable is removed and added again
    val moreVM: MoreVM = viewModel()
    BuildMore(state = moreVM.moreState.value, moreVM::processIntent)
}

@Composable
fun BuildMore(state: MoreState, processIntent: (MoreIntent) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Text(text = state.randomText, Modifier.padding(bottom = 32.dp))

        Button(onClick = { processIntent(MoreIntent.GenerateNewText) }) {
            Text(text = "Generate New Text")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMore() {
    BuildMore(state = MoreState.DEFAULT_STATE, {})
}