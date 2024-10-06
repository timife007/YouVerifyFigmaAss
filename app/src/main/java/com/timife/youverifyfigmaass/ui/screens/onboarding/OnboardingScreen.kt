package com.timife.youverifyfigmaass.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier
) {
    val pageState = rememberPagerState(initialPage = 0, 0f) { pages.count() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DashesIndicator(
            pageState,
            pages.count(),
            Color.Black,
            MaterialTheme.colorScheme.surface,
            modifier = Modifier.padding(top = Dimens.grid_3)
        )
        HorizontalPager(state = pageState) {
            OnBoardingScreenItem(onBoardModel = pages[it])
        }
    }
}

@Composable
fun DashesIndicator(
    pageState: PagerState,
    count: Int,
    activeColor: Color,
    inactiveColor: Color,
    modifier: Modifier
) {
    Row(modifier.padding(Dimens.grid_2), horizontalArrangement = Arrangement.spacedBy(Dimens.grid_0_5)) {
        repeat(count) { index ->
            val color = if (pageState.currentPage == index) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .height(Dimens.grid_0_5)
                    .background(color, shape = RoundedCornerShape(Dimens.grid_2))
            )
        }
    }
}

val pages = listOf(
    OnBoardModel(
        titleText = "Track Your \nExpenses",
        subtitleText = "Get insights into where your money goes and make informed financial decisions.",
        imageId = R.drawable.onboard_image_1
    ),
    OnBoardModel(
        titleText = "Set Savings \nGoals",
        subtitleText = "Whether it's for a vacation, a new car, or an emergency fund, we help you stay on track.",
        imageId = R.drawable.onboard_image_2
    ),
    OnBoardModel(
        titleText = "Get Financial \nInsights",
        subtitleText = "Access detailed reports and analytics to make better financial choices.",
        imageId = R.drawable.onboard_image_3
    )
)

@Preview
@Composable
fun OnboardingScreenPreview() {
    YouVerifyFigmaAssTheme {
        OnboardingScreen(modifier = Modifier)
    }
}