package com.timife.youverifyfigmaass.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.timife.youverifyfigmaass.R

// Define and load the fonts of the app

//ubuntu
private val mrLight = Font(R.font.capriola_regular, FontWeight.Light)
private val mrRegular = Font(R.font.capriola_regular, FontWeight.Normal)
private val mrMedium = Font(R.font.capriola_regular, FontWeight.Medium)
private val mrBold = Font(R.font.capriola_regular, FontWeight.Bold)

// Create a font family to use in TextStyles
val capriolaFontFamily = FontFamily(mrLight, mrRegular, mrMedium, mrBold)

// Use the font family to define a custom typography
val vertexTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 64.sp,
        fontWeight = FontWeight.Medium
    ),
    displayMedium = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 44.sp,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineLarge = TextStyle(
        fontFamily = capriolaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = capriolaFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = capriolaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = capriolaFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontFamily = capriolaFontFamily
    ),
    bodyMedium = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    labelLarge = TextStyle(
        fontFamily = capriolaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    labelMedium = TextStyle(
        fontFamily = capriolaFontFamily,
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    )
)
