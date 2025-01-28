# **Android Media App 📱**

This project is an Android application that uses the MVVM architecture to fetch and display Movies and TV Shows from The Movie Database (TMDb) API.

## **Features 🚀**

Fetch Movies & TV Shows: Retrieves data using TMDb API.

MVVM Architecture: Clean separation of concerns for maintainable code.

Koin for Dependency Injection: Simplifies dependency management.

Jetpack Compose UI: Modern UI toolkit for dynamic and responsive designs.

Navigation Component: Smooth and efficient navigation between screens.

## **Tech Stack 🛠️**

Programming Language: Kotlin

Architecture: MVVM

Dependency Injection: Koin

UI Framework: Jetpack Compose

Networking: Retrofit, Gson

State Management: StateFlow

## **Code Structure 📂**

API Layer: ApiInterface defines endpoints for fetching Movies and TV Shows.

Models: Data classes like Movies and TvShows represent API responses.

Repository: MovieRepository handles data operations and provides clean data to ViewModels.

ViewModel: MovieViewModel connects the Repository with UI.

Dependency Injection:

    - DiModules sets up Koin modules for dependency injection.

    - Dependencies such as ApiInterface and MovieViewModel are injected where needed.

UI Layer: Compose screens like HomeScreen and DetailsScreen for displaying content.

## **Setup Instructions 🔧**

Clone this repository.

Add your TMDb API key in the BASE_URL within the provideRetrofit() function.

Build and run the app on your device or emulator.


# **Output**

## **HomeScreen**

For Movies

![WhatsApp Image 2025-01-28 at 17 20 49](https://github.com/user-attachments/assets/c844d088-0970-4c0d-b047-fcab58d818a4)

For Tv Shows:

![WhatsApp Image 2025-01-28 at 17 20 49 (1)](https://github.com/user-attachments/assets/2711b3e8-5c8d-40e9-9547-e9ab680f3d42)



## **DetailsScreen**

![WhatsApp Image 2025-01-28 at 17 20 49 (2)](https://github.com/user-attachments/assets/22264a87-10cf-4f85-ac82-6e7968ed3841)


