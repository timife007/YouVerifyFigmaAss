package com.timife.youverifyfigmaass.ui.screens.common

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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
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
fun AppButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(Dimens.grid_2)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
fun SignInOption(){
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
    onDismiss: () -> Unit
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(Dimens.grid_4)
                    .background(MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .clickable {
                        scope
                            .launch { sheetState.hide() }
                            .invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    onDismiss()
                                }
                            }
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Cancel",
                    tint = Color.White,
                    modifier = Modifier.size(Dimens.grid_2)
                )
            }
        }

        Text(
            text = "By pressing accept below you agree to our Terms and Conditions. You can find out more about how we use your data in our Privacy Policy",
            style = MaterialTheme.typography.bodyMedium
        )

        AppButton(modifier = Modifier.fillMaxWidth(), text = "Accept and Continue") {

        }
    }
}

@Composable
fun AuthField(
    modifier: Modifier,
    title: String,
    text:String,
    label:String,
){
    Column {
        Text(text = title, style = MaterialTheme.typography.bodyMedium)
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
        var openBottomSheet by remember {
            mutableStateOf(false)
        }

        val bottomSheetState = rememberModalBottomSheetState()

        Button(onClick = { openBottomSheet = true }) {
            Text(text = "Show Bottom Sheet")
        }

        if (openBottomSheet) {
            BottomSheetDialog(
                sheetContent = {
                    CreateUserBottomContent(sheetState = bottomSheetState) {
                        openBottomSheet = false
                    }
                },
                onDismiss = {
                    openBottomSheet = false
                }, sheetState = bottomSheetState
            )
        }
    }
}