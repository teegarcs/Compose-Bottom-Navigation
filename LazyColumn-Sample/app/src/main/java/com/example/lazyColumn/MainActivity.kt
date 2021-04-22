package com.example.lazyColumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyColumn.ui.theme.ComposeCodeLabTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                LazyColumnExample()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeCodeLabTheme {
        Surface(color = Color.White) {
            content()
        }
    }
}

@Composable
fun LazyColumnExample() {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val listSize = 1000
    Column(Modifier.fillMaxWidth()) {
        LazyColumn(state = listState, modifier = Modifier.weight(1f)) {
            items(listSize) {
                if (it % 2 == 0) {
                    RowItem("Item #$it", Color.White)
                } else {
                    RowItem("Item #$it", Color.LightGray)
                }
            }
        }
        Button(onClick = {
            scope.launch {
                listState.scrollToItem(0)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("scroll to top")
        }
    }
}

@Composable
fun RowItem(text: String, backgroundColor: Color) {
    Text(
        text = text, modifier = Modifier
            .background(backgroundColor)
            .padding(8.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        LazyColumnExample()
    }
}