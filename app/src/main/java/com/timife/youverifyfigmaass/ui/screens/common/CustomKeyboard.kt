package com.timife.youverifyfigmaass.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timife.youverifyfigmaass.R
import com.timife.youverifyfigmaass.ui.screens.auth.OtpTextField
import com.timife.youverifyfigmaass.ui.theme.Dimens
import com.timife.youverifyfigmaass.ui.theme.YouVerifyFigmaAssTheme

@Composable
fun CustomKeyBoard(modifier: Modifier,input: String, onSignOutClicked: () -> Unit, onInputChange: (String) -> Unit) {
    var cursorPosition by remember { mutableIntStateOf(0) }

    // List of button labels including Delete
    val buttons = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("Sign out", "0", "x"),
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Dimens.grid_0_25),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OtpTextField(otpText = input) { text, isComplete ->
            onInputChange(text)
            cursorPosition = text.length
        }

        Spacer(modifier = Modifier.height(Dimens.grid_8))

        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { label ->
                    when (label) {
                        "x" -> CustomKeyboardButton(
                            label,
                            modifier = Modifier.weight(0.3f),
                            extra = {
                                Icon(
                                    painter = painterResource(id = R.drawable.delete),
                                    modifier = it.size(Dimens.grid_4),
                                    tint = MaterialTheme.colorScheme.onBackground,
                                    contentDescription = ""
                                )
                            },
                            onClick = {
                                onInputChange(
                                    deleteCharacter(
                                        input,
                                        cursorPosition
                                    ) { updatedPosition -> cursorPosition = updatedPosition })
                            })

                        "Sign out" -> CustomKeyboardButton(
                            label,
                            modifier = Modifier.weight(0.3f),
                            color = MaterialTheme.colorScheme.primary,
                            onClick = {
                                onSignOutClicked()
                            })

                        else -> CustomKeyboardButton(
                            label,
                            modifier = Modifier
                                .clip(RoundedCornerShape(Dimens.grid_0_25))
                                .weight(0.3f)
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            onClick = {
                                onInputChange(insertCharacter(
                                    input,
                                    label,
                                    cursorPosition
                                ) { updatedPosition -> cursorPosition = updatedPosition })
                            })
                    }
                }
            }
        }
    }
}

// Inserts a character at the current cursor position
fun insertCharacter(
    text: String,
    character: String,
    cursorPosition: Int,
    onPositionChanged: (Int) -> Unit
): String {
    val newText = text.substring(0, cursorPosition) + character + text.substring(cursorPosition)
    onPositionChanged(cursorPosition + 1)
    return newText
}

// Deletes the character at the current cursor position
fun deleteCharacter(text: String, cursorPosition: Int, onPositionChanged: (Int) -> Unit): String {
    if (cursorPosition > 0) {
        val newText = text.removeRange(cursorPosition - 1, cursorPosition)
        onPositionChanged(cursorPosition - 1) // Move cursor left after deletion
        return newText
    }
    return text
}

@Composable
fun CustomKeyboardButton(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.onBackground,
    extra: @Composable (Modifier) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clickable {
                onClick()
            }
            .height(48.dp)

    ) {
        extra(Modifier.align(Alignment.Center))
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            color = color,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun CancelButton() {
//    Box(modifier = Modifier){
//        Icon(imageVector = Icons.Outlined., contentDescription = )
//    }
}

@Preview
@Composable
fun CustomKeyBoardPreview() {
    YouVerifyFigmaAssTheme {
        var inputText by remember { mutableStateOf("") }
        CustomKeyBoard(
            modifier = Modifier,
            inputText, {

            }
        ) {
            inputText = it
        }
    }
}