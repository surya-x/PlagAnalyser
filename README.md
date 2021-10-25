# PlagAnalyser
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://github.com/surya-x/PlagAnalyser/blob/main/LICENSE)

PlagAnalyser is a android app which can be used to check Plagiarism between the given texts. It uses Vector similarity metric to find the percentage of plagiarism between the texts. 

The idea is to create an app implementing a Plagiarism Algorithm on Android and using Architecture Components for learning. 

The codebase focuses on following key things:
- MVVM Architecture
- Room Database (SQLite)
- Dependency injection 🗡
- Kotlin
- Unit tests 🛠

# Development Setup 🖥

You will require latest version of Android Studio 3.0 (or newer) to be able to build the app.


## Libraries and tools 🛠

News App uses libraries and tools used to build Modern Android application, mainly part of Android Jetpack 🚀

- [Kotlin](https://kotlinlang.org/) first
- Architecture components
- [Room Database](https://developer.android.com/training/data-storage/room) to save data in a local database 🗡
- [MVVM Architecture](https://developer.android.com/jetpack/guide)
- Other [Android Jetpack](https://developer.android.com/jetpack) components


## Architecture

The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.

Read more: 
- [Building Modern Android Apps with Architecture Guidelines](https://medium.com/@aky/building-modern-apps-using-the-android-architecture-guidelines-3238fff96f14)
- [Guide to app architecture](https://developer.android.com/jetpack/docs/guide)

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)



--------------------
