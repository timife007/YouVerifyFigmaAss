package com.timife.youverifyfigmaass.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.screens.common.CustomChip
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Green5

@Composable
fun NewUserAccountActivity(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(Dimens.grid_2),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_1)
    )  {
        Text(text = "You have no activities yet", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Hi there, you have no linked bank accounts", style = MaterialTheme.typography.bodySmall)
        CustomChip(
            background = Green5,
            text = "Link account",
            iconTint = MaterialTheme.colorScheme.primary
        )

        Image(painter = painterResource(id = R.drawable.no_activity), contentDescription = "")
    }
}