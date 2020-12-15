package android.example.starwars.repos

import android.example.starwars.data.local.MovieLocalDataSource
import android.example.starwars.data.remote.MovieRemoteDataSource
import android.example.starwars.utils.performGetOperation

/**
 * Movie repository that contains the remote API Calls and local DAO methods
 */
class MovieRepository(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) {

    fun getMovie(id: Int) = movieLocalDataSource.getMovie(id)

    fun getAllMovies() = performGetOperation(
        databaseQuery = {movieLocalDataSource.getMovies() },
        networkCall = {movieRemoteDataSource.getMovies()},
        saveCallResult = {movieLocalDataSource.saveMovies(it.movies) }
    )
        }