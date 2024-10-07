package com.timife.youverifyfigmaass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.timife.youverifyfigmaass.ui.screens.SplashScreen
import com.timife.youverifyfigmaass.ui.screens.auth.CreatePasscodeScreen
import com.timife.youverifyfigmaass.ui.screens.auth.CreateUserScreen
import com.timife.youverifyfigmaass.ui.screens.auth.EmailVerificationScreen
import com.timife.youverifyfigmaass.ui.screens.auth.OTPromptScreen
import com.timife.youverifyfigmaass.ui.screens.auth.PasscodeScreen
import com.timife.youverifyfigmaass.ui.screens.auth.SignInPromptScreen
import com.timife.youverifyfigmaass.ui.screens.budget.BudgetScreen
import com.timife.youverifyfigmaass.ui.screens.common.ScreenRoute
import com.timife.youverifyfigmaass.ui.screens.expenses.ExpensesScreen
import com.timife.youverifyfigmaass.ui.screens.gettingstarted.GettingStartedScreen
import com.timife.youverifyfigmaass.ui.screens.home.HomeScreen
import com.timife.youverifyfigmaass.ui.screens.onboarding.OnboardingScreen
import com.timife.youverifyfigmaass.ui.screens.savings.CreateSavingsScreen
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            YouVerifyFigmaAssTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }

            }
        }
    }
}

val items = listOf(
    ScreenRoute.HomeScreen,
    ScreenRoute.BudgetsScreen,
    ScreenRoute.SavingsScreen,
    ScreenRoute.ExpenseScreen,
    ScreenRoute.AccountScreen,
)

@Composable
fun NavigationScreens(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.SplashScreen.route,
    ) {
        composable(ScreenRoute.HomeScreen.route) {
            HomeScreen(Modifier)
        }
        composable(ScreenRoute.BudgetsScreen.route) {
            BudgetScreen()
        }
        composable(ScreenRoute.SavingsScreen.route) {
            CreateSavingsScreen {

            }
        }
        composable(ScreenRoute.ExpenseScreen.route) {
            ExpensesScreen()
        }
        composable(ScreenRoute.AccountScreen.route) {}
        composable(ScreenRoute.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(ScreenRoute.SignupScreen.route) {
            CreateUserScreen(Modifier, navController)
        }

        composable(ScreenRoute.SignInPrompt.route) {
            SignInPromptScreen(navController)
        }

        composable((ScreenRoute.OnBoardingScreen.route)) {
            OnboardingScreen(modifier = Modifier, navController)
        }
        composable(ScreenRoute.EmailVerificationScreen.route) {
            EmailVerificationScreen(modifier = Modifier, navController = navController)
        }

        composable(ScreenRoute.OTPPromptScreen.route) {
            OTPromptScreen(navController = navController)
        }

        composable(ScreenRoute.GettingStartedScreen.route) {
            GettingStartedScreen(modifier = Modifier, navController = navController)
        }

        composable(ScreenRoute.PasscodeScreen.route) {
            PasscodeScreen(modifier = Modifier, navController = navController)
        }
        composable(ScreenRoute.CreatePasscodeScreen.route) { 
            CreatePasscodeScreen(modifier = Modifier, navController = navController)
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val showBottomBar = shouldShowBottomBar(navController)

    Scaffold(bottomBar = {
        if (showBottomBar) {
            BottomNavBar(navController)
        }
    }) { innerPadding ->
        NavigationScreens(navController = navController, innerPadding)
    }
}

@Composable
fun shouldShowBottomBar(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return when (navBackStackEntry?.destination?.route) {
        ScreenRoute.HomeScreen.route, ScreenRoute.SavingsScreen.route, ScreenRoute.ExpenseScreen.route, ScreenRoute.AccountScreen.route, ScreenRoute.BudgetsScreen.route -> true
        else -> false
    }
}

// Simple Bottom Navigation Bar
@Composable
fun BottomNavBar(navController: NavHostController) {
    NavigationBar {
        items.forEachIndexed { index, screenRoute ->


            NavigationBarItem(
                selected = navController.currentDestination?.route == items[index].route,
                onClick = {
                    navController.navigate(screenRoute.route)
                },
                label = {
                    Text(text = screenRoute.label, style = MaterialTheme.typography.labelSmall)
                },
                icon = {
                    Icon(painter = painterResource(id = screenRoute.icon), contentDescription = "")
                })
        }
    }
}
