plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    id("org.owasp.dependencycheck") version "8.4.3"
}

dependencyCheck {
    failBuildOnCVSS = 7f
    formats = listOf("HTML", "JSON")
    suppressionFile = "suppression.xml"
    analyzers {
        assemblyEnabled = false
        nodeEnabled = false
    }
}