package com.example.sample.UserInterface

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(
    title: String,
    overview: String,
    releaseDate: String,
    isMovieSelected: Boolean,
    navController: NavHostController
) {
    val decodedTitle = Uri.decode(title)
    val decodedOverview = Uri.decode(overview)
    val decodedReleaseDate = Uri.decode(releaseDate)


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Title: $decodedTitle",
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Overview: ",
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = decodedOverview,
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Release Date: ",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            )
            Text(
                text = decodedReleaseDate,
                style = MaterialTheme.typography.body1.copy(color = Color.Red)
            )

            Spacer(modifier = Modifier.height(16.dp))


            Button(onClick = {
                navController.navigate("home/$isMovieSelected") {
                    popUpTo("home/$isMovieSelected") { inclusive = true }
                }
            }) {
                Text("Back")
            }
        }
    }
}
