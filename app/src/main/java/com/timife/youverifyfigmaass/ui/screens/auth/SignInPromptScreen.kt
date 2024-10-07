package com.timife.youverifyfigmaass.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.AuthField
import com.timife.youverifyfigmaass.ui.screens.common.BottomTextOption
import com.timife.youverifyfigmaass.ui.screens.common.ScreenRoute
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun SignInPromptScreen(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = Dimens.grid_2, end = Dimens.grid_2, top = Dimens.grid_5, bottom =
                Dimens.grid_5
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_3)
    ) {
        Text(
            text = "Welcome back",
            modifier = Modifier,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(R.string.sign_in_to_your_account_and_start_managing_your_finances_with_fintrack_today),
            style = MaterialTheme.typography.bodyMedium
        )
        AuthField(
            modifier = Modifier,
            title = stringResource(R.string.email_address),
            text = "",
            label = stringResource(R.string.e_g_email_gmail_com),
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(modifier = Modifier, text = "Sign In") {
            navController.navigate(ScreenRoute.OTPPromptScreen.route)
        }
        BottomTextOption(stringResource(R.string.do_not_have_an_account), "Sign Up")


    }
}

@Preview
@Composable
fun SignInPromptScreenPreview(){
    YouVerifyFigmaAssTheme {
        SignInPromptScreen(rememberNavController())
    }
}