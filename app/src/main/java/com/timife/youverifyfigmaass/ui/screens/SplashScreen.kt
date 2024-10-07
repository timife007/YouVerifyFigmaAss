package com.timife.youverifyfigmaass.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.timife.youverifyfigmaass.ui.screens.common.ScreenRoute
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController:NavController
) {
    LaunchedEffect(key1 = true) {
        delay(2000L) // 3 seconds delay
        navController.navigate(ScreenRoute.OnBoardingScreen.route) {
            popUpTo(ScreenRoute.SplashScreen.route) { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .align(
                    Alignment.Center
                )
                .wrapContentSize()
                .padding(Dimens.grid_2),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "fintrack.",
                modifier = Modifier.padding(Dimens.grid_1_5),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge,
            )
        }

    }

}

@Preview
@Composable
fun SplashScreenPreview() {
    YouVerifyFigmaAssTheme {
        SplashScreen(navController = rememberNavController())
    }
}