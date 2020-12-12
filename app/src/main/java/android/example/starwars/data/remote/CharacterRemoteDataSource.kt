package android.example.starwars.data.remote

import android.example.starwars.data.BaseDataSource

class CharacterRemoteDataSource(val apiService: StarWarsApiService)  : BaseDataSource(){
    suspend fun getCharacters() = getResult {
        apiService.getAllCharacters(1)
        apiService.getAllCharacters(2)
    }
}