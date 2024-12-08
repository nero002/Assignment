package com.nero.upstox.data.feature.postfolio

import com.nero.upstox.data.localDB.UserHoldingModel

data class DataResponse(val data: UserData)
data class UserData(val userHolding: List<UserHoldingResponse>)
data class UserHoldingResponse(
    val symbol: String,
    val quantity: Int,
    val ltp: Double,
    val avgPrice: Double,
    val close: Double
)

fun UserHoldingResponse.toUserHoldingModel(): UserHoldingModel {
    return UserHoldingModel(
        symbol = symbol,
        quantity = quantity,
        ltp = ltp,
        avgPrice = avgPrice,
        close = close
    )
}
