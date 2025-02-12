package org.a7medelnoor.snowEffect

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform