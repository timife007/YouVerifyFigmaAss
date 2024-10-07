package com.timife.youverifyfigmaass.ui.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CurrencyRuble
import androidx.compose.material.icons.rounded.IncompleteCircle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.theme.Black1
import com.timife.youverifyfigmaass.ui.theme.Green1
import com.timife.youverifyfigmaass.ui.theme.Green5
import com.timife.youverifyfigmaass.ui.theme.Orange1
import com.timife.youverifyfigmaass.ui.theme.Orange2
import com.timife.youverifyfigmaass.ui.theme.Orange4
import com.timife.youverifyfigmaass.ui.theme.Orange5

val homeCardItems = listOf(
    HomeCardModel(
        title = "Account balance",
        amount = "$ 1, 000, 500.55",
        tag = "Manage Accounts",
        details = "The total balance from your linked accounts",
        Green1,
        Color.White,
        Color.White
    ),
    HomeCardModel(
        "Total savings",
        "$50,530.00",
        "View Savings",
        "You need $250,000 to meet your targets",
        Orange1,
        Color.White,
        Color.White
    ),
    HomeCardModel(
        "Monthly budget",
        "$ 1, 000, 500.55",
        "Manage Budget",
        "left out of $200,000,000 budgeted",
        Color.White,
        Black1,
        Green1
    ),
    HomeCardModel(
        "Total expenses",
        "$ 1, 000, 500.55",
        "View expenses",
        "spent in the last 7 days",
        Orange5,
        Black1,
        Green1
    )
)

data class HomeCardModel(
    val title: String,
    val amount: String,
    val tag: String,
    val details: String,
    val background: Color,
    val contentColor: Color,
    val chip: Color
)

data class OnBoardModel(
    val titleText: String,
    val subtitleText: String = "",
    val imageId: Int,
)

val pages = listOf(
    OnBoardModel(
        titleText = "Track Your \nExpenses",
        subtitleText = "Get insights into where your money goes and make informed financial decisions.",
        imageId = R.drawable.onboard_image_1
    ),
    OnBoardModel(
        titleText = "Set Savings \nGoals",
        subtitleText = "Whether it's for a vacation, a new car, or an emergency fund, we help you stay on track.",
        imageId = R.drawable.onboard_image_2
    ),
    OnBoardModel(
        titleText = "Get Financial \nInsights",
        subtitleText = "Access detailed reports and analytics to make better financial choices.",
        imageId = R.drawable.onboard_image_3
    )
)

data class ActivitiesModel(
    val title: String,
    val time: String,
    val icon: ImageVector,
    val iconBackTint: Color,
    val price: String
)

val recentActivities = listOf(
    ActivitiesModel(
        "Created a new budget  'Trip to \n" +
                "Nairobi'", "a day ago", Icons.Rounded.IncompleteCircle, Orange5, "$ 200, 000"
    ),
    ActivitiesModel("Paul Ogaga", "Zenith Bank 12:03 AM", Icons.Rounded.CurrencyRuble, Green5, "$10, 000")
)

data class TimeBasedActivityModel(
    val time:String,
    val activity: List<ActivitiesModel>
)

val timeBasedActivities = listOf(
    TimeBasedActivityModel("Today, 14/07/2024", recentActivities),
    TimeBasedActivityModel("Yesterday, 13/07/2024", recentActivities)
)