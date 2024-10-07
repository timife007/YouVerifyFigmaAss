package com.timife.youverifyfigmaass.ui.screens.auth

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.CustomKeyBoard
import com.timife.youverifyfigmaass.ui.screens.common.ScreenRoute
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun PasscodeScreen(
    modifier: Modifier,
    navController: NavController
) {
    var otp by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Dimens.grid_2),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_2)
    ) {
        Text(
            text = stringResource(R.string.welcome_back),
            modifier = Modifier.padding(top = Dimens.grid_8),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.jane_doe),
            modifier = Modifier,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(Dimens.grid_10))
        CustomKeyBoard(modifier = Modifier.background(MaterialTheme.colorScheme.background),input = otp, onSignOutClicked = {}) {
            otp = it
        }
        Spacer(modifier = Modifier.weight(1f))

        AppButton(modifier = Modifier, text = "Continue") {
            navController.navigate(ScreenRoute.GettingStartedScreen.route)
        }
    }

}

@Preview
@Composable
fun PasscodeScreenPreview() {
    YouVerifyFigmaAssTheme {
        PasscodeScreen(modifier = Modifier, navController = rememberNavController())
    }
}