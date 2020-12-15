package android.example.starwars.data.remote

import android.example.starwars.data.BaseDataSource

/**
 * Character datasource that calls the [StarWarsApiService] HTTP Request for a remote handling of information
 * @param apiService
 */
class CharacterRemoteDataSource(val apiService: StarWarsApiService)  : BaseDataSource(){

    suspend fun getCharacters() = getResult {
        apiService.getAllCharacters(1)
    }

}