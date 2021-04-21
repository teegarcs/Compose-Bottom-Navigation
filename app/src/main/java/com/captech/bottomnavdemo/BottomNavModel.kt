package com.captech.bottomnavdemo

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavModel(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    object Home : BottomNavModel("home", R.string.home, Icons.Default.Home)
    object Shop : BottomNavModel("shop", R.string.shop, Icons.Default.ShoppingCart)
    object More : BottomNavModel("more", R.string.more, Icons.Default.Settings)
}