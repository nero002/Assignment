package com.nero.upstox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.nero.upstox.presentation.ResourceUI
import com.nero.upstox.presentation.feature.portfolio.UserHoldingViewModel
import com.nero.upstox.presentation.feature.portfolio.state.UserHoldingUiState
import com.nero.upstox.presentation.feature.portfolio.ui.components.ErrorWidget
import com.nero.upstox.presentation.feature.portfolio.ui.components.LoadingWidget
import com.nero.upstox.presentation.feature.portfolio.ui.components.UserHoldingsScreen
import com.nero.upstox.ui.theme.UpstoxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UpstoxTheme {
                val viewModel by viewModels<UserHoldingViewModel>()
                val uiState by viewModel.userHoldings.collectAsState()
                when (uiState) {
                    ResourceUI.Loading -> LoadingWidget()
                    is ResourceUI.Error -> ErrorWidget(
                        (uiState as ResourceUI.Error).message,
                        viewModel::fetchData
                    )

                    is ResourceUI.Success -> UserHoldingsScreen((uiState as ResourceUI.Success<UserHoldingUiState>).data)
                }
            }
        }
    }
}

