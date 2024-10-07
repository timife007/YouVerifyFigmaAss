package com.timife.youverifyfigmaass.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timife.youverifyfigmaass.ui.screens.common.CircleImage
import com.timife.youverifyfigmaass.ui.screens.common.CustomChip
import com.timife.youverifyfigmaass.ui.screens.common.timeBasedActivities
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.Green5

@Composable
fun ExistingUserActivity(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(Dimens.grid_1),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_2_5)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Recent Activities",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            CustomChip(
                background = Green5,
                text = "View All",
                iconTint = MaterialTheme.colorScheme.primary
            )
        }
        timeBasedActivities.forEach {
            Text(
                text = it.time,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.surface
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(Dimens.grid_2),
                horizontalAlignment = Alignment.Start
            ) {
                it.activity.forEach {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(Dimens.grid_2)
                    ) {
                        CircleImage(
                            imageVector = it.icon,
                            iconTint = MaterialTheme.colorScheme.primary,
                            background = it.iconBackTint
                        ) {

                        }
                        Column {
                            Text(
                                text = it.title,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = it.time,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.surface
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = it.price,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

    }
}