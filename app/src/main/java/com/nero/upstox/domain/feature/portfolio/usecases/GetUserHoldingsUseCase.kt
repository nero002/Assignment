package com.nero.upstox.domain.feature.portfolio.usecases

import com.nero.upstox.domain.ResourceData
import com.nero.upstox.domain.feature.portfolio.repository.UserHoldingRepository
import com.nero.upstox.data.localDB.UserHoldingModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserHoldingsUseCase @Inject constructor(private val repository: UserHoldingRepository) {
    fun userHoldingUseCase(): Flow<ResourceData<List<UserHoldingModel>?>> {
        return repository.getUserHoldings()
    }
}