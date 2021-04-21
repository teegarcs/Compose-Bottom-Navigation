package com.captech.bottomnavdemo.shop

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ShopScreen() {
    // ViewModel scoped to BackStackEntry, will reset every time composable is removed and added again
    val shopVM: ShopVM = viewModel()
    BuildShop(state = shopVM.shopState.value)
}

@Composable
fun BuildShop(state: ShopState) {
    ConstraintLayout {
        // Creates references for the three Composables
        val (button1, button2, text) = createRefs()

        Button(
            // constraintAs is like setting the ID, required.
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            },
            onClick = {}
        ) {
            Text("Button 1")
        }

        // constraintAs is like setting the ID, required.
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

        // Create barrier to set the right button to the right of the
        //button or the text, which ever is longer.
        val barrier = createEndBarrier(button1, text)
        Button(
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            },
            onClick = {}
        ) {
            Text("Button 2")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewShop() {
    BuildShop(state = ShopState.DEFAULT_STATE)
}