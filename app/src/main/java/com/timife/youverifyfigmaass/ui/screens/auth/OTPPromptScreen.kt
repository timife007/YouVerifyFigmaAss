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
fun OTPromptScreen(
    navController: NavController
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = Dimens.grid_2, end = Dimens.grid_2, top = Dimens.grid_5, bottom = Dimens.grid_5
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_3)
    ) {
        Text(
            text = "Check your email!",
            modifier = Modifier,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(R.string.we_have_sent_an_email_to_janedoe_gmail_com_please_remember_to_check_your_inbox_as_well_as_the_spam_folder),
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = stringResource(R.string.please_enter_the_one_time_passcode_otp_below_to_continue_with_your_account),
            style = MaterialTheme.typography.bodyMedium
        )

        AuthField(
            modifier = Modifier,
            title = stringResource(R.string.enter_one_time_passcode_otp),
            text = "",
            label = stringResource(R.string.enter_code_here)
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(modifier = Modifier, text = "Continue") {
            navController.navigate(ScreenRoute.PasscodeScreen.route)
        }
        BottomTextOption(
            firstText = stringResource(R.string.didn_t_receive_the_email),
            clickableText = stringResource(R.string.resend_code_in_50s)
        )

    }

}

@Preview
@Composable
fun OTPPromptScreePreview(){
    YouVerifyFigmaAssTheme {
        OTPromptScreen(rememberNavController())
    }
}