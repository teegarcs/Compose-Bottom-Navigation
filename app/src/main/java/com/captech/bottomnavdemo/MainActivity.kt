package com.captech.bottomnavdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.captech.bottomnavdemo.home.HomeScreen
import com.captech.bottomnavdemo.more.MoreScreen
import com.captech.bottomnavdemo.shop.ShopScreen
import com.captech.bottomnavdemo.ui.theme.BottomNavDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            BottomNavDemoTheme {
                // A surface container using the 'background' color from the theme
                MainScaffold()
            }
        }
    }
}

@Composable
fun MainScaffold() {
    val navController = rememberNavController()
    val navigation = listOf(BottomNavModel.Home, BottomNavModel.Shop, BottomNavModel.More)

    Surface(color = MaterialTheme.colors.background) {

        Scaffold(
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

                    navigation.forEach {
                        BottomNavigationItem(
                            label = { Text(text = stringResource(id = it.label)) },
                            selected = currentRoute == it.route,
                            icon = { Icon(it.icon, stringResource(id = it.label)) },
                            onClick = {
                                //this adds your composable each time, and removes others in the back stack
                                navController.navigate(it.route) {
                                    popUpTo = navController.graph.startDestination
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavHost(navController = navController, startDestination = "home") {
                    composable(BottomNavModel.Home.route) { HomeScreen() }
                    composable(BottomNavModel.Shop.route) { ShopScreen() }
                    composable(BottomNavModel.More.route) { MoreScreen() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomNavDemoTheme {
        MainScaffold()
    }
}