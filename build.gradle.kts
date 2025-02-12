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
    autoUpdate = true
    failBuildOnCVSS = 7.0f
    format = "ALL"
    outputDirectory = layout.buildDirectory.dir("reports").get().asFile
    suppressionFile = "suppression.xml"
    scanConfigurations = listOf("runtimeClasspath", "compileClasspath")
}

tasks.named("dependencyCheckAnalyze") {
    dependsOn("clean")
}