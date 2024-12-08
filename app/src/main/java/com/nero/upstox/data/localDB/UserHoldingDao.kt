package com.nero.upstox.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserHoldingDao {
    @Query("SELECT * FROM user_holdings")
    fun getAllHoldings(): Flow<List<UserHoldingModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(holdings: List<UserHoldingModel>)

    @Query("DELETE FROM user_holdings")
    suspend fun deleteAll()
}
