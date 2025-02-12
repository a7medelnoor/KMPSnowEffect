# KMP Snow Effect

A Kotlin Multiplatform project that implements a beautiful snow effect animation for Android, iOS, and Web platforms using Compose Multiplatform.

## Dependencies & Versions

### Kotlin & Compose
- Kotlin Multiplatform: 1.9.22
- Compose Multiplatform: 1.5.11
- Kotlin Wasm: 1.9.22

### Android
- Android Gradle Plugin: 8.2.0
- Android Compile SDK: 34
- Android Min SDK: 24

### Libraries
- Compose Material3: 1.1.2
- Kotlin Coroutines: 1.7.3
- Kotlin Serialization: 1.6.2

### Build & Tools
- Gradle: 8.5
- JVM Target: 17
- Xcode: 15.0.1

## Project Structure

This is a Kotlin Multiplatform project targeting Android, iOS, Web.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that's common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple's CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you're sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.