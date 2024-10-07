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
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.timife.youverifyfigmaass.ui.screens.common.pages
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier,
    navController: NavController
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
            OnBoardingScreenItem(onBoardModel = pages[it], navController = navController)
        }
    }
}

@Composable
fun DashesIndicator(
    pageState: PagerState,
    count: Int,
    activeColor: Color,
    inactiveColor: Color,
    thickness: Dp = Dimens.grid_0_5,
    modifier: Modifier
) {
    Row(modifier.padding(Dimens.grid_2), horizontalArrangement = Arrangement.spacedBy(Dimens.grid_0_5)) {
        repeat(count) { index ->
            val color = if (pageState.currentPage == index) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .height(thickness)
                    .background(color, shape = RoundedCornerShape(Dimens.grid_2))
            )
        }
    }
}



@Preview
@Composable
fun OnboardingScreenPreview() {
    YouVerifyFigmaAssTheme {
        OnboardingScreen(modifier = Modifier, rememberNavController())
    }
}