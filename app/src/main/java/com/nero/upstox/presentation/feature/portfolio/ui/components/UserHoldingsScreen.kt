package com.nero.upstox.presentation.feature.portfolio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nero.upstox.R
import com.nero.upstox.presentation.feature.portfolio.state.UserHoldingUiState
import com.nero.upstox.ui.BottomNavigationMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserHoldingsScreen(data: UserHoldingUiState) {
    Scaffold(bottomBar = { BottomNavigationMenu(2) {} }, topBar = {
        TopAppBar(actions = {
            Icon(
                painter = painterResource(R.drawable.upanddown),
                contentDescription = "Watchlist",
                modifier = Modifier.padding(horizontal = 12.dp),
                tint = Color.White
            )
            Icon(
                Icons.Rounded.Search,
                contentDescription = "Watchlist",
                modifier = Modifier.padding(horizontal = 12.dp),
                tint = Color.White
            )
        },
            title = {
                Text(
                    text = "Portfolio",
                    style = TextStyle(fontSize = 18.sp, fontFamily = FontFamily.SansSerif)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF003366),
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White
            ), navigationIcon = {
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = "Watchlist",
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            })
    }) { contentPadding ->
        Column(Modifier.padding(contentPadding)) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.positions),
                    modifier = Modifier.weight(1f),
                    color = Color.Gray,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                Text(
                    text = stringResource(R.string.holdings),
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

            }
            HorizontalDivider(thickness = 1.dp)
            StockList(data)
        }
    }
}
