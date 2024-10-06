package com.timife.youverifyfigmaass.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreenItem(
    modifier: Modifier = Modifier,
    onBoardModel: OnBoardModel
) {
    var openBottomSheet by remember {
        mutableStateOf(false)
    }
    val bottomSheetState = rememberModalBottomSheetState()

    if (openBottomSheet) {
        BottomSheetDialog(sheetContent = {
            CreateUserBottomContent(sheetState = bottomSheetState) {
                openBottomSheet = false
            }
        }, onDismiss = {
            openBottomSheet = false
        }, sheetState = bottomSheetState)
    }


    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .wrapContentSize()
            .padding(Dimens.grid_2),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_3)
    ) {
        Text(
            text = onBoardModel.titleText,
            modifier = Modifier,
            style = MaterialTheme.typography.displaySmall
        )

        Text(text = onBoardModel.subtitleText)
        Image(
            painter = painterResource(id = onBoardModel.imageId),
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimens.grid_2),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(modifier = Modifier.fillMaxWidth(), text = "Create an account") {
                openBottomSheet = true
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account?", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.size(Dimens.grid_1))
                Text(
                    text = "Sign In",
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.primary)
                )
            }
        }
    }

}

data class OnBoardModel(
    val titleText: String,
    val subtitleText: String = "",
    val imageId: Int,
)


@Preview
@Composable
fun OnBoardingScreenPreview() {
    YouVerifyFigmaAssTheme {
        OnBoardingScreenItem(
            modifier = Modifier,
            onBoardModel = OnBoardModel(
                titleText = "Set Savings \nGoals",
                subtitleText = "Get insights into where your money goes and make informed financial decisions.",
                imageId = R.drawable.onboard_image_2
            )
        )
    }
}