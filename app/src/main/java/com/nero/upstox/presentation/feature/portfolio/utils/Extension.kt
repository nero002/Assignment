package com.nero.upstox.presentation.feature.portfolio.utils

import java.text.NumberFormat
import java.util.Locale

fun Double.roundOffDecimal(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    return format.format(this)
}
