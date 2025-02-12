package org.a7medelnoor.snowEffect.composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.delay
import org.a7medelnoor.snowEffect.data.SnowPile
import org.a7medelnoor.snowEffect.data.Snowflake
import org.a7medelnoor.snowEffect.util.createSnowflake
import kotlin.random.Random
import kotlin.math.*

@Composable
fun SnowEffect() {
    Box(modifier = Modifier.fillMaxSize()) {
        var size by remember { mutableStateOf(IntSize(0, 0)) }
        var snowflakes by remember { mutableStateOf(emptyList<Snowflake>()) }
        var snowPiles by remember { mutableStateOf(mutableListOf<SnowPile>()) }

        LaunchedEffect(size) {
            if (size.width > 0 && size.height > 0) {
                val pointCount = size.width / 8
                snowPiles = MutableList(pointCount) { index ->
                    val x = index * (size.width.toFloat() / pointCount)
                    val baseHeight = size.height * 0.15f // Lower base height
                    val mountain1 =
                        sin(x * PI.toFloat() / 180) * size.height * 0.05f // Reduced height
                    val mountain2 = sin(x * PI.toFloat() / 90) * size.height * 0.03f
                    val randomVariation = Random.nextFloat() * size.height * 0.02f

                    SnowPile(x, baseHeight + mountain1 + mountain2 + randomVariation)
                }
                snowflakes =
                    List(150) { createSnowflake(size.width.toFloat(), size.height.toFloat()) }
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(16)
                snowflakes = snowflakes.map { flake ->
                    if (!flake.active) return@map flake

                    flake.y += flake.speed
                    flake.x += sin(flake.y * 0.05f) * 0.5f

                    // Find the closest pile point
                    val pileIndex = (flake.x / (size.width.toFloat() / snowPiles.size))
                        .toInt()
                        .coerceIn(0, snowPiles.size - 1)

                    val totalHeight =
                        snowPiles[pileIndex].height + snowPiles[pileIndex].additionalHeight
                    val groundHeight = size.height - totalHeight

                    if (flake.y >= groundHeight) {
                        // Accumulate snow on the existing terrain
                        snowPiles[pileIndex] = snowPiles[pileIndex].copy(
                            additionalHeight = snowPiles[pileIndex].additionalHeight + 0.1f
                        )

                        // Create new snowflake at top
                        createSnowflake(size.width.toFloat(), size.height.toFloat())
                    } else {
                        flake
                    }
                }

                // Smooth out the accumulated snow between adjacent piles
                snowPiles = snowPiles.mapIndexed { index, pile ->
                    if (index > 0 && index < snowPiles.size - 1) {
                        val leftHeight = snowPiles[index - 1].additionalHeight
                        val rightHeight = snowPiles[index + 1].additionalHeight
                        val avgHeight = (leftHeight + rightHeight + pile.additionalHeight) / 3
                        pile.copy(additionalHeight = avgHeight)
                    } else {
                        pile
                    }
                }.toMutableList()
            }
        }

        Canvas(modifier = Modifier.fillMaxSize().onSizeChanged { size = it }) {
            // Draw background gradient
            val backgroundGradient = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF1a365d),
                    Color(0xFF2c5282),
                    Color(0xFF2b6cb0)
                )
            )
            drawRect(brush = backgroundGradient)

            // Draw terrain with accumulated snow
            val snowGradient = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFFFFF),
                    Color(0xFFF0F0F0),
                    Color(0xFFE8E8E8)
                )
            )

            val path = Path()
            path.moveTo(0f, size.height.toFloat())

            // Create smooth terrain curves with accumulated snow
            snowPiles.forEachIndexed { index, pile ->
                val totalHeight = pile.height + pile.additionalHeight
                if (index == 0) {
                    path.lineTo(pile.x, size.height - totalHeight)
                } else {
                    val prevPile = snowPiles[index - 1]
                    val prevTotalHeight = prevPile.height + prevPile.additionalHeight
                    val midX = (prevPile.x + pile.x) / 2
                    val midY = size.height - (prevTotalHeight + totalHeight) / 2
                    path.quadraticTo(
                        midX, midY,
                        pile.x, size.height - totalHeight
                    )
                }
            }

            path.lineTo(size.width.toFloat(), size.height.toFloat())
            path.close()

            drawPath(
                path = path,
                brush = snowGradient,
                style = Fill
            )

            // Draw falling snowflakes
            snowflakes.forEach { snowflake ->
                if (snowflake.active) {
                    drawCircle(
                        color = Color.White,
                        radius = snowflake.size,
                        center = Offset(snowflake.x, snowflake.y),
                        alpha = snowflake.alpha
                    )
                }
            }
        }
    }
}
