package com.nero.upstox.presentation.feature.portfolio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nero.upstox.R
import com.nero.upstox.presentation.feature.portfolio.state.PortfolioState
import com.nero.upstox.presentation.feature.portfolio.utils.roundOffDecimal

@Composable
fun CollapsibleCard(portfolioState: PortfolioState?, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 2.dp)
        ) {
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(expandFrom = Alignment.Top),
                exit = shrinkVertically(shrinkTowards = Alignment.Top)
            ) {
                Column {
                    InfoRow(
                        label = stringResource(R.string.current_value),
                        value = "${portfolioState?.currentValue?.roundOffDecimal()}"
                    )
                    InfoRow(
                        label = stringResource(R.string.total_investment),
                        value = "${portfolioState?.totalInvestment?.roundOffDecimal()}"
                    )
                    InfoRow(
                        label = stringResource(R.string.todays_profit_loss),
                        value = "${portfolioState?.todayProfitLoss?.roundOffDecimal()}",
                        isError = true
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = (0.5).dp,
                        color = Color.Gray
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Profit & Loss*",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )

                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = null
                        )
                    }
                }

                Text(
                    text = "${portfolioState?.totalProfitLoss?.roundOffDecimal()}",
                    color = Color.Red,
                    fontSize = 18.sp
                )
            }
        }
    }
}