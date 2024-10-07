package com.timife.youverifyfigmaass.ui.screens.budget

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.AuthField
import com.timife.youverifyfigmaass.ui.screens.common.CircleImage
import com.timife.youverifyfigmaass.ui.screens.common.CustomChip
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Grey3
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun BudgetPageOne(

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
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_1)
    ) {
        CreateBudgetAppbar(
            {},
            "1 of 3",
            iconColor = MaterialTheme.colorScheme.primary
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.grid_2)

        ) {
            CreateBudgetHeading(
                "Create your budget",
                "For a more secure and convenient way to view your account, create a 4-digit passcode now"
            )
            AuthField(
                modifier = Modifier,
                title = "Name of budget",
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
            listOf("Monthly Budget", "Weekly Budget").forEach {
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
        AppButton(modifier = Modifier, text = "Next") {
        }
    }
}

@Composable
fun CreateBudgetHeading(title: String, subtitle: String) {
    Text(
        text = title,
        modifier = Modifier.padding(top = Dimens.grid_4),
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center
    )
    Text(
        text = subtitle,
        modifier = Modifier,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun CreateBudgetAppbar(
    onClick: () -> Unit,
    text: String,
    iconColor: Color
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        CircleImage(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
            background = iconColor
        ) {
            onClick()
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun BudgetPageOnePreview() {
    YouVerifyFigmaAssTheme {
        BudgetPageOne()
    }
}