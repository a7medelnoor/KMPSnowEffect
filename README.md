# KMP Snow Effect

A Kotlin Multiplatform project that implements a beautiful snow effect animation for Android, iOS, and Web platforms using Compose Multiplatform. The project demonstrates the power of code sharing with a single codebase for both platforms.

## 📱 Screenshots/Demo
### Demo Video

<img src=".github/media/videos/snow_effect_demo.gif" width="300" alt="Snow Effect Demo"/>

### Screenshots

#### Android
<p float="left">
  <img src=".github/media/screenshots/android_portrait.png" width="240" alt="Android Portrait"/>
  <img src=".github/media/screenshots/android_landscape.png" width="480" alt="Android Landscape"/>
</p>

#### iOS
<p float="left">
  <img src=".github/media/screenshots/ios_portrait.png" width="240" alt="iOS Portrait"/>
  <img src=".github/media/screenshots/ios_landscape.png" width="480" alt="iOS Landscape"/>
</p>

## ✨ Features
- Beautiful snow animation effect
- Cross-platform support (Android, iOS)
- Customizable snow parameters
- Built with Compose Multiplatform
- Pure Kotlin implementation

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog | 2023.1.1
- Xcode 15.0.1+ (for iOS)
- JDK 17

### Running the Project
1. Clone the repository

bash
git clone https://github.com/a7medelnoor/KMPSnowEffect.git

2. Open the project in Android Studio

3. Run on different platforms:
- Android: Run 'composeApp' configuration
- iOS: Open iosApp/iosApp.xcworkspace in Xcode and run


## 🛠️ Technology Stack

### Core Technologies
- **Kotlin**: Primary language for cross-platform development
  - Kotlin Multiplatform for sharing code across platforms
  - Kotlin Coroutines for asynchronous programming

### UI Framework
- **Compose Multiplatform**: Modern declarative UI
  - Shared UI components across platforms
  - Material 3 design implementation
  - Custom animations for snow effect

### Platform-Specific
- **Android**: Native Android implementation
- **iOS**: Swift/SwiftUI integration

## 📦 Dependencies & Versions

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

## 📁 Project Structure

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that's common for all targets
  - Other folders are for platform-specific Kotlin code

* `/iosApp` contains iOS applications. Even if you're sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

## 🎯 Code Structure & Architecture

### Shared Code (`/composeApp/commonMain`)
Our project follows a clean, shared codebase architecture where all core logic and UI are written once and shared across platforms:

#### 📦 Package Structure
```
org.a7medelnoor.snowEffect/
├── composable/
│   └── SnowEffect.kt         # Main snow animation composable
├── data/
│   ├── Snowflake.kt         # Snowflake data model
│   └── SnowPile.kt          # Snow accumulation model
├── util/
│   └── createSnowflake.kt   # Utility function
├── App.kt                   # Main app composition
└── Platform.kt              # Platform-specific interface
```

#### Key Components

1. **SnowEffect Composable** (`SnowEffect.kt`)
   - Core animation logic using Compose Canvas
   - Handles snow particle physics and accumulation
   - Implements smooth terrain generation
   - Uses coroutines for animation updates

2. **Data Models**
   - `Snowflake`: Represents individual snow particles with properties like position, size, and speed
   - `SnowPile`: Manages snow accumulation and terrain formation

3. **Shared UI**
   - Single UI implementation works identically on both platforms
   - Material Design theme integration
   - Custom drawing and animations using Compose Canvas

### Cross-Platform Benefits
- **Write Once, Run Anywhere**: The entire snow effect is implemented once in Kotlin and works on both Android and iOS
- **Consistent Behavior**: Same animation physics and visual effects across platforms
- **Maintainable Code**: Single codebase reduces bugs and makes updates easier
- **Shared Resources**: Common graphics and animations

## 🤝 Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## 📝 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## 🙏 Acknowledgments
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)

## 📬 Contact
Ahmed Elnoor - [@a7medelnoor](https://twitter.com/a7medelnoor)

Project Link: [https://github.com/a7medelnoor/KMPSnowEffect](https://github.com/a7medelnoor/KMPSnowEffect)