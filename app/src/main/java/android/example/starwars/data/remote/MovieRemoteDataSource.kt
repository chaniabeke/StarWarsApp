package android.example.starwars.data.remote

import android.example.starwars.data.BaseDataSource

/**
 * Mocvie datasource that calls the [StarWarsApiService] HTTP Request for a remote handling of information
 * @param apiService
 */
class MovieRemoteDataSource(val apiService: StarWarsApiService)  : BaseDataSource(){

    suspend fun getMovies() = getResult {
        apiService.getAllMovies()
    }

}