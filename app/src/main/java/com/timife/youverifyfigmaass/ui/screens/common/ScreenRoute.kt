package com.timife.youverifyfigmaass.ui.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Approval
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Restore
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.timife.youverifyfigmaass.R

sealed class ScreenRoute(val route: String, val label: String, val icon: Int) {
    data object SplashScreen : ScreenRoute("SplashScreen", "Splash Screen", R.drawable.delete)
    data object SignupScreen : ScreenRoute("Signup Screen", "Signup", R.drawable.home)
    data object OnBoardingScreen :
        ScreenRoute("Onboarding", "Onboarding", R.drawable.onboard_image_1)

    data object LoginScreen : ScreenRoute("Login Screen", "Login", R.drawable.onboard_image_3)

    data object HomeScreen : ScreenRoute("home_screen", "Home", icon = R.drawable.home)
    data object BudgetsScreen :
        ScreenRoute("budgets_screen", "Budgets", icon = R.drawable.graph)

    data object SavingsScreen : ScreenRoute("savings", "Savings", R.drawable.wallet)
    data object ExpenseScreen :
        ScreenRoute("expenses_screen", "Expenses", R.drawable.swap)

    data object AccountScreen : ScreenRoute("account_Screen", "Account", R.drawable.profile)
    data object EmailVerificationScreen : ScreenRoute("email_screen", "Email", R.drawable.home)
    data object SignInPrompt : ScreenRoute("sign-in", "Sign In Prompt", R.drawable.onboard_image_2)
    data object OTPPromptScreen : ScreenRoute("otp-prompt", "OTP Prompt", R.drawable.home)
    data object GettingStartedScreen :
        ScreenRoute("getting-started", "Getting Started", R.drawable.delete)

    data object PasscodeScreen :
        ScreenRoute("passcode-screen", "Passcode Screen", R.drawable.onboard_image_2)

    data object CreatePasscodeScreen :
        ScreenRoute("create-passcode", "Create Passcode", R.drawable.home)
}