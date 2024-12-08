package com.nero.upstox.presentation.feature.portfolio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nero.upstox.R
import com.nero.upstox.data.localDB.UserHoldingModel
import com.nero.upstox.presentation.feature.portfolio.utils.roundOffDecimal

@Composable
fun StockItemRow(stockDetails: UserHoldingModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                stockDetails.symbol,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.W600
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            val shareQuantity = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append(stringResource(R.string.net_qty))
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                    append(" ${stockDetails.quantity}")
                }
            }
            Text(text = shareQuantity)
        }

        Column(horizontalAlignment = Alignment.End) {

            val ltpText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append(stringResource(R.string.ltp))
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                    append(" ${stockDetails.ltp}")
                }
            }
            Text(text = ltpText)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            val profitAndLossText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append(stringResource(R.string.p_l))
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (stockDetails.ltp - stockDetails.avgPrice >= 0) Color(0xFF5dc198) else Color(
                            0xFFf04f59
                        )
                    )
                ) {
                    append(" ${((stockDetails.ltp - stockDetails.avgPrice) * stockDetails.quantity).roundOffDecimal()}")
                }
            }
            Text(text = profitAndLossText)
        }
    }
}