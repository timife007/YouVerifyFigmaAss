package com.timife.youverifyfigmaass.ui.screens.budget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.BorderedCard
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun BudgetScreen(
    onClick:() -> Unit = {},
) {
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
        Text(text = "My Budgets", modifier = Modifier.padding(top = Dimens.grid_2))
        Spacer(modifier = Modifier.height(Dimens.grid_1))
        BorderedCard {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.background)
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(Dimens.grid_2)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Nothing to see here yet",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(Dimens.grid_1))
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Hi there, create a budget to \nget started",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Spacer(modifier = Modifier.height(Dimens.grid_1_5))
                    AppButton(modifier = Modifier, text = "Create a budget") {
                        onClick()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun BudgetScreenPreview() {
    YouVerifyFigmaAssTheme {
        BudgetScreen()
    }
}