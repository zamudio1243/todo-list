package com.example.todo_list.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Primary500,
    primaryVariant = Primary600,
    secondary = Secondary100,

    background = backgroundDark,
    surface = surfaceDark,
    onPrimary = onPrimaryDark,
    onSecondary = onSecondaryDark,
    onBackground = primaryTextDark,
    onSurface =  primaryTextDark,
)

private val LightColorPalette = lightColors(
    primary = Primary800,
    primaryVariant = Primary900,
    secondary = Secondary400,


    background = backgroundLight,
    surface = surfaceLight,
    onPrimary = onPrimaryLight,
    onSecondary = onSecondaryLight,
    onBackground = primaryTextLight,
    onSurface = primaryTextLight,

)

@Composable
fun TodoListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun getCurrentTheme(darkTheme: Boolean = isSystemInDarkTheme()) = if (darkTheme) DarkTheme else LightTheme


interface ComposableTheme{
    val success : Color
    val info : Color
    val warning : Color
    val danger : Color
}