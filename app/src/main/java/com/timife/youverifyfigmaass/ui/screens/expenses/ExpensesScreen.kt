package com.timife.youverifyfigmaass.ui.screens.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Brightness1
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.timife.youverifyfigmaass.ui.screens.common.BorderedCard
import com.timife.youverifyfigmaass.ui.screens.common.CircleImage
import com.timife.youverifyfigmaass.ui.screens.common.HomeCard
import com.timife.youverifyfigmaass.ui.screens.common.ShadowedCard
import com.timife.youverifyfigmaass.ui.screens.common.homeCardItems
import com.timife.youverifyfigmaass.ui.screens.common.timeBasedExpenses
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Orange5
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun ExpensesScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(
                start = Dimens.grid_1,
                end = Dimens.grid_1,
                bottom = Dimens.grid_3,
                top = Dimens.grid_2_5
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_1)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = Dimens.grid_2)

        ) {
            Text(
                text = "My Expenses", modifier = Modifier
                    .weight(1f), textAlign = TextAlign.Center
            )
            Icon(imageVector = Icons.Rounded.Brightness1, contentDescription = "")
        }

        HomeCard(model = homeCardItems[3])
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.grid_1)
                .wrapContentHeight(),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = Dimens.grid_2),
            shape = RoundedCornerShape(Dimens.grid_1)
        ) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(Dimens.grid_1_5),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sort your expenses",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                CircleImage(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
                    background = Orange5,
                    iconTint = MaterialTheme.colorScheme.onBackground
                ) {

                }
            }
        }
        ExistingExpensesPage(timeBasedExpenses)
    }
}


@Preview
@Composable
fun ExpensesScreenPreview() {
    YouVerifyFigmaAssTheme {
        ExpensesScreen()
    }
}