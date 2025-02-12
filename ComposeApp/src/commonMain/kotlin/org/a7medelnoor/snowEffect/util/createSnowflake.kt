package org.a7medelnoor.snowEffect.util

import org.a7medelnoor.snowEffect.data.Snowflake
import kotlin.random.Random

 fun createSnowflake(width: Float, height: Float): Snowflake {
    return Snowflake(
        x = Random.nextFloat() * width,
        y = -20f,
        size = Random.nextFloat() * 3f + 1.5f,
        speed = Random.nextFloat() * 2f + 1.5f,
        alpha = Random.nextFloat() * 0.4f + 0.6f
    )
}
