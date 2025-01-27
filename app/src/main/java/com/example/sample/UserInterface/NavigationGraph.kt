package com.example.sample.UserInterface

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home/{isMovieSelected}",
        route = "root"
    ) {

        composable(
            route = "home/{isMovieSelected}",
            arguments = listOf(
                navArgument("isMovieSelected") {
                    type = NavType.BoolType
                    defaultValue = true
                }
            )
        ) { backStackEntry ->
            val isMovieSelected = backStackEntry.arguments?.getBoolean("isMovieSelected") ?: true
            HomeScreen(navController, isMovieSelected)
        }


        composable(
            route = "details/{title}/{overview}/{releaseDate}/{posterPath}/{isMovieSelected}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("overview") { type = NavType.StringType },
                navArgument("releaseDate") { type = NavType.StringType },
                navArgument("posterPath") { type = NavType.StringType },
                navArgument("isMovieSelected") { type = NavType.BoolType }
            )
        ) { backStackEntry ->
            val title = Uri.decode(backStackEntry.arguments?.getString("title") ?: "")
            val overview = Uri.decode(backStackEntry.arguments?.getString("overview") ?: "No Overview Available")
            val releaseDate = Uri.decode(backStackEntry.arguments?.getString("releaseDate") ?: "")
            val posterPath = Uri.decode(backStackEntry.arguments?.getString("posterPath") ?: "")
            val isMovieSelected = backStackEntry.arguments?.getBoolean("isMovieSelected") ?: true

            DetailsScreen(
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                isMovieSelected = isMovieSelected,
                navController = navController
            )
        }
    }
}
