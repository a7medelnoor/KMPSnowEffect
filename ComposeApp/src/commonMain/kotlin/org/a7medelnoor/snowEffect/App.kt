package org.a7medelnoor.snowEffect

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.a7medelnoor.snowEffect.composable.SnowEffect
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        SnowEffect()
    }
}