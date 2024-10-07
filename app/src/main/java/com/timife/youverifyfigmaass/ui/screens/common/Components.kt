package com.timife.youverifyfigmaass.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme
import kotlinx.coroutines.launch

@Composable
fun V_MultiStyleText(
    text: String,
    disableSecondText: Boolean = false,
    color1: Color,
    color2: Color,
    modifier: Modifier,
    textDecoration: TextDecoration? = null,
    style: TextStyle,
) {
    val s = text.split("\n")
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = color1)) {
                append(s[0])
            }
            withStyle(style = SpanStyle(color = Color.Transparent)) {
                append("\n")
            }
            withStyle(style = SpanStyle(color = color2)) {
                append(if (disableSecondText) "" else s[1])
            }
        },
        modifier = modifier,
        textDecoration = textDecoration,
        style = style.copy(
            textAlign = TextAlign.Start,
        )
    )
}

@Composable
fun AppButton(modifier: Modifier, text: String, buttonColor:Color = MaterialTheme.colorScheme.primary, textColor: Color = MaterialTheme.colorScheme.onPrimary, onClick: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        shape = RoundedCornerShape(Dimens.grid_2)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor
        )
    }
}

@Composable
fun BottomTextOption(
    firstText: String = "Already have an account?",
    clickableText: String = "Sign In"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = firstText, style = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.size(Dimens.grid_1))
        Text(
            text = clickableText,
            style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetDialog(
    modifier: Modifier = Modifier,
    sheetContent: @Composable () -> Unit,
    onDismiss: () -> Unit,
    sheetState: SheetState,
) {
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        dragHandle = null,
        onDismissRequest = {
            onDismiss()
        },
        modifier = Modifier.wrapContentSize(),
        containerColor = MaterialTheme.colorScheme.background,
        sheetState = sheetState
    ) {
        sheetContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateUserBottomContent(
    sheetState: SheetState,
    onAccept:() -> Unit,
    onDismiss: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = Dimens.grid_2_5,
                start = Dimens.grid_2_5,
                end = Dimens.grid_2_5,
                bottom = Dimens.grid_5
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_2_5)
    ) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Create an account", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.weight(1f))
            CircleImage(
                imageVector = Icons.Default.Close,
                background = MaterialTheme.colorScheme.surface
            ) {
                scope
                    .launch { sheetState.hide() }
                    .invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            onDismiss()
                        }
                    }
            }
        }

        Text(
            text = "By pressing accept below you agree to our Terms and Conditions. You can find out more about how we use your data in our Privacy Policy",
            style = MaterialTheme.typography.bodyMedium
        )

        AppButton(modifier = Modifier.fillMaxWidth(), text = "Accept and Continue") {
            onAccept()
        }
    }
}

@Composable
fun CircleImage(
    imageVector: ImageVector,
    background: Color,
    iconTint: Color = Color.White,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(Dimens.grid_4)
            .background(color = background, shape = CircleShape)
            .clickable {
                onClick()
            }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "Cancel",
            tint = iconTint,
            modifier = Modifier.size(Dimens.grid_2)
        )
    }
}



@Composable
fun HomeCard(
    model:HomeCardModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(Dimens.grid_1),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = Dimens.grid_2),
        shape = RoundedCornerShape(Dimens.grid_1)
    ) {
        Column(
            modifier = Modifier
                .background(model.background)
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(Dimens.grid_1),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dimens.grid_1)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = model.title,
                    style = MaterialTheme.typography.bodySmall.copy(color = model.contentColor)
                )
                Spacer(modifier = Modifier.weight(1f))

                CustomChip(background = model.chip, text = model.tag, iconTint = model.background )

            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.grid_1_5),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = model.amount,
                    style = MaterialTheme.typography.headlineMedium.copy(color = model.contentColor)
                )
                Icon(
                    imageVector = Icons.Rounded.Visibility,
                    modifier = Modifier.size(Dimens.grid_3),
                    tint = MaterialTheme.colorScheme.surface,
                    contentDescription = "visibility"
                )
            }

            Text(
                text = model.details,
                modifier = Modifier.padding(bottom = Dimens.grid_1_5),
                style = MaterialTheme.typography.bodySmall.copy(model.contentColor)
            )
        }

    }
}

@Composable
fun ShadowedCard(
    title: String,
    description: String,
    image: Int,
    background: Color = MaterialTheme.colorScheme.background
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = Dimens.grid_2),
        shape = RoundedCornerShape(Dimens.grid_1)
    ) {
        Row(
            modifier = Modifier
                .background(background)
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(Dimens.grid_1),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(
                    Dimens.grid_1
                )
            ) {
                Text(text = title, style = MaterialTheme.typography.bodyMedium)
                Text(text = description, style = MaterialTheme.typography.bodySmall)
            }
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Inside,
                modifier = Modifier.size(Dimens.grid_12_5),
                contentDescription = ""
            )

        }
    }
}

@Composable
fun BorderedCard(content:@Composable () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(Dimens.grid_1),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        colors = CardDefaults.cardColors(),
        shape = RoundedCornerShape(Dimens.grid_1)
    ) {
        content()
    }
}


@Composable
fun CustomChip(
    background: Color,
    text: String,
    iconTint: Color
){
    Row(
        Modifier
            .clip(
                RoundedCornerShape(Dimens.grid_4)
            )
            .background(background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(Dimens.grid_0_5),
            fontSize = 10.sp,
            style = MaterialTheme.typography.labelSmall,
            color = iconTint
        )
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
            modifier = Modifier.size(Dimens.grid_1_5),
            tint = iconTint,
            contentDescription = ""
        )
    }
}

@Composable
fun AuthField(
    modifier: Modifier,
    title: String,
    text: String,
    label: String,
) {
    Column {
        Text(text = title, style = MaterialTheme.typography.labelSmall)
        OutlinedTextField(value = "", onValueChange = {}, label = {
            Text(
                text = label,
                style = TextStyle(color = MaterialTheme.colorScheme.surface)
            )
        }, modifier = Modifier.fillMaxWidth())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ShowBottom() {
    YouVerifyFigmaAssTheme {
        HomeCard(
            homeCardItems[2]
        )
    }
}