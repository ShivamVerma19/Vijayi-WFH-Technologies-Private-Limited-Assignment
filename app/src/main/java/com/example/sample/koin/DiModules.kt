package com.example.sample.koin

import com.example.sample.api.ApiInterface
import com.example.sample.repository.MovieRepository
import com.example.sample.viewModel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { provideRetrofit().create(ApiInterface::class.java) }
    single { MovieRepository(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}

fun provideRetrofit(): Retrofit {
    val BASE_URL = "https://api.themoviedb.org/3/discover/"
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
