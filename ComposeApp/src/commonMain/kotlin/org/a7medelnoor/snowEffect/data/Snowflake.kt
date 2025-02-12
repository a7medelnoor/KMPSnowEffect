package org.a7medelnoor.snowEffect.data

data class Snowflake(
    var x: Float,
    var y: Float,
    val size: Float,
    val speed: Float,
    val alpha: Float,
    var active: Boolean = true
)