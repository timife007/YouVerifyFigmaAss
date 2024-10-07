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
import androidx.compose.ui.tooling.preview.Preview
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.AuthField
import com.timife.youverifyfigmaass.ui.screens.common.BottomTextOption
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun EmailVerificationScreen(
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                Dimens.grid_2
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_3)
    ) {
        Text(
            text = "Check your email!",
            modifier = Modifier,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "We have sent an email to janedoe@gmail.com. Please remember to check your inbox as well as the spam folder",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Please enter the verification code below to continue with your account.",
            style = MaterialTheme.typography.bodyMedium
        )

        AuthField(
            modifier = Modifier,
            title = "Enter verification code",
            text = "",
            label = "Enter code here"
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(modifier = Modifier, text = "Continue") {

        }
        BottomTextOption("Didn't receive the email?", "Resend code in 50s")

    }

}

@Preview
@Composable
fun EmailVerificationPreview() {
    YouVerifyFigmaAssTheme {
        EmailVerificationScreen(
            Modifier
        )
    }
}