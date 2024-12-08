package com.nero.upstox.presentation.feature.portfolio.state

import com.nero.upstox.data.localDB.UserHoldingModel

data class UserHoldingUiState(
    val userHoldingModels: List<UserHoldingModel>? = null,
    var portfolioState: PortfolioState? = null,
)