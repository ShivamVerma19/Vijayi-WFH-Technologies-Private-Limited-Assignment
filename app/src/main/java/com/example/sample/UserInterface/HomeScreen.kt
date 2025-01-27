package com.example.sample.UserInterface

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sample.viewModel.MovieViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavHostController, isMovieSelected: Boolean) {
    val movieViewModel: MovieViewModel = getViewModel()
    var isMovieSelectedState by remember { mutableStateOf(isMovieSelected) }

    LaunchedEffect(isMovieSelectedState) {
        if (isMovieSelectedState) {
            movieViewModel.fetchMovies()
        } else {
            movieViewModel.fetchTvShows()
        }
    }

    val errorMessage by movieViewModel.errorMessage.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                isMovieSelectedState = !isMovieSelectedState
                navController.navigate("home/$isMovieSelectedState") {
                    popUpTo("home/$isMovieSelected") { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(if (isMovieSelectedState) "Move to TV Shows" else "Move to Movies")
        }

        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(16.dp)
            )
        }

        val items = if (isMovieSelectedState) {
            movieViewModel.movies.collectAsState().value
        } else {
            movieViewModel.tvShows.collectAsState().value
        }

        LazyColumn {
            items(items) { item ->
                MovieOrTvItem(
                    title = item.title,
                    description = item.overview,
                    releaseDate = item.releaseDate,
                    onClick = {
                        val safeOverview = if (item.overview.isEmpty()) "No Overview Available" else item.overview
                        navController.navigate(
                            "details/${Uri.encode(item.title)}/${Uri.encode(safeOverview)}/${Uri.encode(item.releaseDate)}/${Uri.encode(item.posterPath)}/$isMovieSelectedState"
                        )
                    }
                )
            }
        }
    }
}



@Composable
fun MovieOrTvItem(
    title: String,
    description: String,
    releaseDate: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, maxLines = 2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Release Date: $releaseDate", style = MaterialTheme.typography.caption)
        }
    }
}
