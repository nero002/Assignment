package com.nero.upstox.data.feature.postfolio

import com.nero.upstox.domain.feature.portfolio.repository.UserHoldingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PortfolioModule {

    @Binds
    abstract fun bindUserHoldingRepository(userHoldingRepositoryImp: UserHoldingRepoImpL): UserHoldingRepository
}