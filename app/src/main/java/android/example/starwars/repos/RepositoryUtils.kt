package android.example.starwars.repos

import android.content.Context
import android.example.starwars.data.local.AppDatabase
import android.example.starwars.data.local.CharacterLocalDataSource
import android.example.starwars.data.local.MovieLocalDataSource
import android.example.starwars.data.remote.CharacterRemoteDataSource
import android.example.starwars.data.remote.MovieRemoteDataSource
import android.example.starwars.data.remote.StarWarsApi

class RepositoryUtils {
    companion object{
        fun createMovieRepository(context: Context) : MovieRepository{
            val database = AppDatabase.getDatabase(context)
            val localDataSource = MovieLocalDataSource(database.movieDao())
            val remoteDataSource = MovieRemoteDataSource(StarWarsApi.apiService)

            return MovieRepository(localDataSource, remoteDataSource)
        }

        fun createCharacterRepository(context: Context) : CharacterRepository{
            val database = AppDatabase.getDatabase(context)
            val localDataSource = CharacterLocalDataSource(database.characterDao())
            val remoteDataSource = CharacterRemoteDataSource(StarWarsApi.apiService)

            return CharacterRepository(localDataSource, remoteDataSource)
        }
    }
}