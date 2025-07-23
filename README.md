# 🏋️ Gym App

A comprehensive Android fitness application designed to help users manage their workout routines, track exercise progress, and maintain a structured fitness plan.

## 📱 Overview

Gym App is a native Android application that provides users with a complete gym management system. Users can browse various training exercises, create personalized workout plans, schedule training sessions for specific days, and track their progress over time.

## ✨ Features

### 🎯 Core Features
- **Exercise Library**: Browse a comprehensive collection of workout exercises including:
  - Push-ups
  - Squats
  - Leg Press
  - Pectorals training
  - Pull-ups
- **Workout Planning**: Create and manage personalized workout plans
- **Schedule Management**: Assign training sessions to specific days of the week
- **Progress Tracking**: Mark completed workouts and track your fitness journey
- **Exercise Details**: View detailed descriptions and instructions for each exercise
- **Visual Content**: Exercise images to help with proper form and technique

### 🔧 Technical Features
- Material Design UI components
- Offline functionality
- Data persistence
- Image loading with optimization
- Responsive design for various screen sizes

## 🛠️ Technologies Used

- **Language**: Java
- **Platform**: Android (API Level 24-34)
- **Architecture**: Android SDK with Activities and Adapters
- **UI Framework**: Material Design Components
- **Image Loading**: Glide (v4.16.0)
- **Build System**: Gradle with Kotlin DSL
- **Development Environment**: Android Studio

### Dependencies
```gradle
implementation 'androidx.appcompat:appcompat'
implementation 'com.google.android.material:material:1.12.0'
implementation 'androidx.activity:activity'
implementation 'androidx.constraintlayout:constraintlayout'
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.recyclerview:recyclerview-selection:1.1.0'
implementation 'com.github.bumptech.glide:glide:4.16.0'
```

## 📋 Prerequisites

Before setting up the project, ensure you have:

- **Android Studio**: Latest stable version (recommended)
- **JDK**: Java Development Kit 8 or higher
- **Android SDK**: API Level 24 (Android 7.0) or higher
- **Gradle**: Version 8.7 (included with Android Studio)
- **Internet Connection**: For downloading dependencies and loading exercise images

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/Rohanvish4/GymApp.git
cd GymApp
```

### 2. Open in Android Studio
1. Launch Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to the cloned `GymApp` directory
4. Click "OK" to open the project

### 3. Sync Project
- Android Studio will automatically prompt to sync the project
- Click "Sync Now" to download all dependencies
- Wait for the sync process to complete

### 4. Configure SDK (if needed)
1. Go to `File` → `Project Structure`
2. Select "SDK Location"
3. Ensure Android SDK path is correctly set
4. Verify API Level 24+ is installed

## 🔨 Building the App

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### Run Tests
```bash
./gradlew test
./gradlew connectedAndroidTest
```

## 📱 Running the App

### Using Android Studio
1. Connect an Android device or start an emulator
2. Click the "Run" button or press `Shift + F10`
3. Select your target device
4. The app will install and launch automatically

### Using Command Line
```bash
./gradlew installDebug
```

## 🏗️ Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/rovot/gymapp/
│   │   │   ├── MainActivity.java          # Main entry point
│   │   │   ├── AllTrainingsActivity.java  # Exercise library screen
│   │   │   ├── TrainingActivity.java      # Individual exercise details
│   │   │   ├── EditActivity.java          # Plan editing interface
│   │   │   ├── PlanActivity.java          # Workout plans management
│   │   │   ├── Training.java              # Exercise data model
│   │   │   ├── Plan.java                  # Workout plan data model
│   │   │   ├── Utils.java                 # Utility functions
│   │   │   ├── TrainingAdapter.java       # RecyclerView adapter for exercises
│   │   │   ├── PlanAdapter.java           # RecyclerView adapter for plans
│   │   │   └── PlanDetailDialog.java      # Plan details dialog
│   │   ├── res/
│   │   │   ├── layout/                    # XML layout files
│   │   │   ├── values/                    # String resources, themes
│   │   │   ├── drawable/                  # Icons and images
│   │   │   └── mipmap/                    # App launcher icons
│   │   └── AndroidManifest.xml            # App configuration
│   ├── test/                              # Unit tests
│   └── androidTest/                       # Instrumentation tests
└── build.gradle.kts                       # Module-level build configuration
```

## 🎮 Usage Guide

### Getting Started
1. **Launch the App**: Open Gym App from your device's app drawer
2. **Main Menu**: You'll see three main options:
   - **Your Plans**: View and manage your workout schedules
   - **All Trainings**: Browse the exercise library
   - **About**: App information

### Managing Workouts
1. **Browse Exercises**: 
   - Tap "All Trainings" to view available exercises
   - Each exercise includes images and detailed descriptions
   - Tap on any exercise to view more details

2. **Create Workout Plans**:
   - Go to "Your Plans" to create new workout schedules
   - Select exercises and assign them to specific days
   - Set workout duration and track completion status

3. **Track Progress**:
   - Mark completed workouts as accomplished
   - View your weekly training schedule
   - Monitor your fitness journey over time

## 🤝 Contributing

We welcome contributions to improve Gym App! Here's how you can help:

### Development Workflow
1. **Fork the Repository**
   ```bash
   git fork https://github.com/Rohanvish4/GymApp.git
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Changes**
   - Follow Android development best practices
   - Maintain code style consistency
   - Add comments for complex logic

4. **Test Your Changes**
   ```bash
   ./gradlew test
   ./gradlew connectedAndroidTest
   ```

5. **Submit Pull Request**
   - Provide a clear description of changes
   - Include screenshots for UI changes
   - Reference any related issues

### Code Style Guidelines
- Follow standard Java naming conventions
- Use meaningful variable and method names
- Add appropriate comments and documentation
- Maintain consistent indentation (4 spaces)
- Follow Material Design guidelines for UI components

### Reporting Issues
- Use the GitHub Issues tab to report bugs
- Provide detailed steps to reproduce issues
- Include device information and Android version
- Attach screenshots when relevant

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🎯 Future Enhancements

- [ ] User authentication and profiles
- [ ] Cloud synchronization for workout data
- [ ] Advanced progress analytics and charts
- [ ] Social features (sharing workouts)
- [ ] Custom exercise creation
- [ ] Integration with fitness wearables
- [ ] Nutrition tracking
- [ ] Video tutorials for exercises
- [ ] Dark mode support
- [ ] Multiple language support

## 📞 Support

If you encounter any issues or have questions:

1. **Check the Issues**: Look for existing solutions in [GitHub Issues](https://github.com/Rohanvish4/GymApp/issues)
2. **Create New Issue**: If you can't find a solution, create a new issue with detailed information
3. **Community**: Engage with other users and contributors in the discussions

## 🙏 Acknowledgments

- Material Design team for UI/UX guidelines
- Glide library for efficient image loading
- Android development community for best practices
- All contributors who help improve this project

---

**Made with ❤️ for the fitness community**

*Last updated: July 2024*