package com.timife.youverifyfigmaass.ui.screens.savings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.timife.youverifyfigmaass.ui.screens.budget.BudgetPageOne
import com.timife.youverifyfigmaass.ui.screens.budget.CreateBudgetAppbar
import com.timife.youverifyfigmaass.ui.screens.budget.CreateBudgetHeading
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.AuthField
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Grey3
import com.timife.youverifyfigmaass.ui.theme.Orange1
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme


@Composable
fun SavingScreenOne(){
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
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_1)
    ) {
        CreateBudgetAppbar(
            {},
            "1 of 4",
            iconColor = Orange1
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.grid_2)

        ) {
            CreateBudgetHeading(
                "Create your saving goal",
                "Setup a personal savings goal. e.g Rent, a car or a trip"
            )
            AuthField(
                modifier = Modifier,
                title = "What are you saving for?",
                text = "",
                label = "Enter the name of your budget here"
            )

        }
        Spacer(modifier = Modifier.height(Dimens.grid_2))
        Text(text = "Quick picks", textAlign = TextAlign.Start)
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimens.grid_1),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            listOf("House rent", "School fees", "A car").forEach {
                Row(
                    Modifier
                        .clip(
                            RoundedCornerShape(Dimens.grid_4)
                        )
                        .background(Grey3),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(Dimens.grid_1),
                        fontSize = 10.sp,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        AppButton(modifier = Modifier, buttonColor = Orange1, text = "Next") {
        }
    }
}

@Preview
@Composable
fun SavingScreenOnePreview() {
    YouVerifyFigmaAssTheme {
        SavingScreenOne()
    }
}