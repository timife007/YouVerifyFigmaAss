package com.timife.youverifyfigmaass.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timife.youverifyfigmaass.ui.screens.common.AppButton
import com.timife.youverifyfigmaass.ui.screens.common.AuthField
import com.timife.youverifyfigmaass.ui.screens.common.SignInOption
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun CreateUserScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp),
    ) {
        Text(
            text = "Let's get started!",
            modifier = Modifier,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(Dimens.grid_1_5))
        Text(
            text = "Join us and start managing your finances with Fintrack today",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(Dimens.grid_5))
        AuthField(
            modifier = Modifier.fillMaxWidth(),
            title = "First & Last Name",
            text = "",
            label = "e.g John Doe"
        )
        Spacer(modifier = Modifier.height(Dimens.grid_2_5))
        AuthField(
            modifier = Modifier.fillMaxWidth(),
            title = "Email address",
            text = "",
            label = "e.g email@mail.com"
        )
        Spacer(modifier = Modifier.height(Dimens.grid_2_5))
        AuthField(
            modifier = Modifier.fillMaxWidth(),
            title = "Enter a referral code(optional)",
            text = "",
            label = "e.g email@mail.com"
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(modifier = Modifier, text = "Create an account") {

        }
        SignInOption()
        Spacer(modifier = Modifier.height(Dimens.grid_5))
    }
}

@Preview
@Composable
fun CreateUserScreenPreview() {
    YouVerifyFigmaAssTheme {
        CreateUserScreen(
            Modifier
        )
    }
}