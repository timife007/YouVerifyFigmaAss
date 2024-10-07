package com.timife.youverifyfigmaass.ui.screens.gettingstarted

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.ScreenRoute
import com.timife.youverifyfigmaass.ui.screens.common.ShadowedCard
import com.timife.youverifyfigmaass.ui.screens.common.setUpItems
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun GettingStartedScreen(
    modifier: Modifier,
    navController: NavController
) {

    val title = buildAnnotatedString {
        append("Welcome to")
        pushStyle(SpanStyle(color = MaterialTheme.colorScheme.primary))
        append(" Fintrack!")
        pop()
        append("\nLet's get you set up.")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                start = Dimens.grid_2,
                bottom = Dimens.grid_5,
                top = Dimens.grid_5,
                end = Dimens.grid_2
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_0_5)
    ) {
        Text(text = title, modifier = Modifier.padding(Dimens.grid_1))
        Spacer(modifier = Modifier.height(Dimens.grid_2))
        setUpItems.forEach {
            ShadowedCard(title = it.title, description = it.description, image = it.image)
        }
        Spacer(modifier = Modifier.weight(1f))
        AppButton(modifier = Modifier.padding(bottom = Dimens.grid_3), text = "Skip for now") {
            navController.navigate(ScreenRoute.CreatePasscodeScreen.route)
        }
    }


}


@Preview
@Composable
fun GettingStartedScreenPreview() {
    YouVerifyFigmaAssTheme {
        GettingStartedScreen(Modifier, rememberNavController())
//        ShadowedCard(title = "", description = "", image = R.drawable.onboard_image_2)
    }
}