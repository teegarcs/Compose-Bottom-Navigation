package com.example.modifiersexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiersexample.ui.theme.ModifiersExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifiersExampleTheme {
                MyFakeButton()
            }
        }
    }
}

@Composable
fun MyFakeButton() {
    Text(
        text = "Fake Button",
        modifier = Modifier
            .background(Color.Magenta)
            .padding(10.dp)
            .border(1.dp, Color.Black)
            .background(Color.Yellow)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifiersExampleTheme {
        MyFakeButton()
    }
}