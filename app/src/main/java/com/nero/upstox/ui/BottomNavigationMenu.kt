package com.nero.upstox.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.nero.upstox.R

@Composable
fun BottomNavigationMenu(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    BottomAppBar(
        contentColor = Color.Black
    ) {
        NavigationBarItem(icon = {
            Icon(
                Icons.AutoMirrored.Filled.List,
                contentDescription = "Watchlist"
            )
        },
            label = { Text(stringResource(R.string.watchlist)) },
            selected = selectedItem == 0,
            onClick = { onItemSelected(0) })
        NavigationBarItem(icon = {
            Icon(
                painter = painterResource(R.drawable.ic_clock_icon),
                contentDescription = "Orders"
            )
        },
            label = { Text(stringResource(R.string.orders)) },
            selected = selectedItem == 1,
            onClick = { onItemSelected(1) })
        NavigationBarItem(icon = { Icon(Icons.Filled.DateRange, contentDescription = "Portfolio") },
            label = { Text(stringResource(R.string.portfolio)) },
            selected = selectedItem == 2,
            onClick = { onItemSelected(2) })
        NavigationBarItem(icon = {
            Icon(
                painter = painterResource(R.drawable.rupee), contentDescription = "Funds"
            )
        },
            label = { Text(stringResource(R.string.funds)) },
            selected = selectedItem == 3,
            onClick = { onItemSelected(3) })
        NavigationBarItem(icon = {
            Icon(
                painter = painterResource(R.drawable.investment_icon),
                contentDescription = "Invest"
            )
        },
            label = { Text(stringResource(R.string.invest)) },
            selected = selectedItem == 4,
            onClick = { onItemSelected(4) })
    }
}