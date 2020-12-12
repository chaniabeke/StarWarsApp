package android.example.starwars.data.remote

import android.example.starwars.data.BaseDataSource
import android.example.starwars.data.remote.StarWarsApiService

class MovieRemoteDataSource(val apiService: StarWarsApiService)  : BaseDataSource(){
    suspend fun getMovies() = getResult {apiService.getAllMovies()}
}