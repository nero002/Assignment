package com.nero.upstox.data.localDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_holdings")
data class UserHoldingModel(
    @PrimaryKey val symbol: String,
    val quantity: Int,
    val ltp: Double,
    val avgPrice: Double,
    val close: Double
)
