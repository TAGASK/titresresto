package com.example.titresresto.listanddetails.feature

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.base.tools.theme.LightBlue
import com.example.base.tools.theme.Shapes
import com.example.base.tools.theme.Typography

private val LightColorPalette = darkColors(
    primary = Color.Black,
    background = Color.White,
    onBackground = Color.White,
    surface = LightBlue,
    onSurface = Color.White
)

@Composable
fun TitresRestoAppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}