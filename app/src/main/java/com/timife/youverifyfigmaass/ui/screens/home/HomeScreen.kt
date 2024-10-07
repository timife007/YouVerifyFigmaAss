package com.timife.youverifyfigmaass.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.CurrencyRuble
import androidx.compose.material.icons.rounded.IncompleteCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.screens.common.BorderedCard
import com.timife.youverifyfigmaass.ui.screens.common.CircleImage
import com.timife.youverifyfigmaass.ui.screens.common.CustomChip
import com.timife.youverifyfigmaass.ui.screens.common.HomeCard
import com.timife.youverifyfigmaass.ui.screens.common.homeCardItems
import com.timife.youverifyfigmaass.ui.screens.common.recentActivities
import com.timife.youverifyfigmaass.ui.screens.common.timeBasedActivities
import com.timife.youverifyfigmaass.ui.screens.onboarding.DashesIndicator
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Green5
import com.timife.youverifyfigmaass.ui.theme.Orange1
import com.timife.youverifyfigmaass.ui.theme.Orange5
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    val pageState = rememberPagerState(initialPage = 0, 0f) { homeCardItems.count() }
    Scaffold(topBar = { HomeAppBar() }) { padding ->
        Column(
            modifier = Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pageState, modifier = Modifier.padding(Dimens.grid_1)) {
                HomeCard(model = homeCardItems[it])
            }
            DashesIndicator(
                pageState = pageState,
                count = homeCardItems.count(),
                thickness = Dimens.grid_0_25,
                activeColor = MaterialTheme.colorScheme.primary,
                inactiveColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.width(100.dp)
            )

            BorderedCard {
                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(Dimens.grid_1),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val workText = buildAnnotatedString {
                        pushStyle(
                            SpanStyle(
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        )
                        append(stringResource(R.string.your_week_in))

                        pop()
                        pushStyle(SpanStyle(fontSize = 24.sp, color = Orange1))

                        append(stringResource(R.string.money))
                        pop()
                    }
                    Column(verticalArrangement = Arrangement.spacedBy(Dimens.grid_0_5)) {
                        Text(
                            text = workText,
                            lineHeight = 30.sp
                        )
                        Text(
                            text = "See your past week in money",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = 10.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CircleImage(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
                        background = Green5,
                        iconTint = MaterialTheme.colorScheme.primary
                    ) {

                    }
                }
            }

            BorderedCard {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(Dimens.grid_1),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Dimens.grid_2_5)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = "Recent Activities",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        CustomChip(
                            background = Green5,
                            text = "View All",
                            iconTint = MaterialTheme.colorScheme.primary
                        )
                    }
                    timeBasedActivities.forEach {
                        Text(
                            text = it.time,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.surface
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(Dimens.grid_2),
                            horizontalAlignment = Alignment.Start
                        ) {
                            it.activity.forEach {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(Dimens.grid_2)
                                ) {
                                    CircleImage(
                                        imageVector = it.icon,
                                        iconTint = MaterialTheme.colorScheme.primary,
                                        background = it.iconBackTint
                                    ) {

                                    }
                                    Column {
                                        Text(
                                            text = it.title,
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                        Text(
                                            text = it.time,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.surface
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = it.price,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun HomeAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.grid_2),
        horizontalArrangement = Arrangement.spacedBy(Dimens.grid_1),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Hello, Jane", style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "Your financial journey starts here.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        CircleImage(
            imageVector = Icons.Rounded.Person,
            background = Orange5,
            iconTint = MaterialTheme.colorScheme.onBackground
        ) {

        }

        CircleImage(
            imageVector = Icons.Rounded.Notifications,
            background = Orange5,
            iconTint = MaterialTheme.colorScheme.onBackground
        ) {

        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {

    YouVerifyFigmaAssTheme {
        HomeScreen(modifier = Modifier)
    }

}