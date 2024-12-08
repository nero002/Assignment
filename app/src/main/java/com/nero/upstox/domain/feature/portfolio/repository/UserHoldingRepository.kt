package com.nero.upstox.domain.feature.portfolio.repository

import com.nero.upstox.data.localDB.UserHoldingModel
import com.nero.upstox.domain.ResourceData
import kotlinx.coroutines.flow.Flow

interface UserHoldingRepository {
    fun getUserHoldings(): Flow<ResourceData<List<UserHoldingModel>?>>
}
